package com.github.akosbordas.ncore;

import com.github.akosbordas.ncore.authentication.CredentialsProvider;
import com.github.akosbordas.ncore.authentication.LoginService;
import com.github.akosbordas.ncore.search.SearchCriterion;
import com.github.akosbordas.ncore.search.TorrentTypeCriterion;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.github.akosbordas.ncore.TorrentType.MOVIE_DVD;
import static ie.corballis.fixtures.assertion.FixtureAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class DefaultNcoreClientTest extends IntegrationTestBase {

    public static final String TEMP_DIR = System.getProperty("java.io.tmpdir");

    public static final Path DOWNLOADED_FILE_PATH =
        Paths.get(TEMP_DIR, "[nCore][xvid_hun]Inception.2010.BDRip.Xvid.Hun-PpB.torrent");

    @Mock()
    private LoginService loginService;

    private NcoreClient ncoreClient;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        CredentialsProvider.setUsername("username");
        CredentialsProvider.setPassword("password");

        ncoreClient = new DefaultNcoreClient();
        ((DefaultNcoreClient) ncoreClient).setLoginService(loginService);
    }

    @After
    public void tearDown() throws Exception {
        CredentialsProvider.setUsername(null);
        CredentialsProvider.setPassword(null);
        if (Files.exists(DOWNLOADED_FILE_PATH)) {
            Files.delete(DOWNLOADED_FILE_PATH);
        }
    }

    @Test
    public void shouldSearchForTermAndFindResults() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readFile("torrent-list.html"));
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        List<TorrentListElement> results = ncoreClient.search("inception");
        verify(loginService, times(1)).login(eq("username"), eq("password"));

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);
        verify(httpClient, times(1)).execute(requestCaptor.capture());

        HttpUriRequest httpRequest = requestCaptor.getValue();
        assertThat(httpRequest).matches("shouldSearchForTermAndFindResults-request");
        assertThat(results).matches("shouldSearchForTermAndFindResults-results");
    }

    @Test
    public void shouldFindResultsInMultipleTorrentType() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readFile("torrent-list-with-type-filters.html"));
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        TorrentType englishMovie = TorrentType.MOVIE_HD;
        englishMovie.setEnglish(true);

        List<TorrentListElement> results = ncoreClient.search("inception",
                                                              new TorrentTypeCriterion(MOVIE_DVD),
                                                              new TorrentTypeCriterion(englishMovie));
        verify(loginService, times(1)).login(eq("username"), eq("password"));

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);
        verify(httpClient, times(1)).execute(requestCaptor.capture());

        HttpUriRequest httpRequest = requestCaptor.getValue();
        assertThat(httpRequest).matches("shouldFindResultsInMultipleTorrentType-request");
        assertThat(results).matches("shouldFindResultsInMultipleTorrentType-results");
    }

    @Test
    public void shouldSearchForTermAndFindResultsWhenCriteriaIsNull() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readFile("torrent-list.html"));
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        List<SearchCriterion> citeria = null;

        List<TorrentListElement> results = ncoreClient.search("inception", citeria);
        verify(loginService, times(1)).login(eq("username"), eq("password"));

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);
        verify(httpClient, times(1)).execute(requestCaptor.capture());

        HttpUriRequest httpRequest = requestCaptor.getValue();
        assertThat(httpRequest).matches("shouldSearchForTermAndFindResults-request");
        assertThat(results).matches("shouldSearchForTermAndFindResults-results");
    }

    @Test
    public void shouldSearchForTermAndFindNoResults() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readFile("torrent-list-no-results.html"));
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        List<TorrentListElement> results = ncoreClient.search("inception");
        verify(loginService, times(1)).login(eq("username"), eq("password"));

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);
        verify(httpClient, times(1)).execute(requestCaptor.capture());

        HttpUriRequest httpRequest = requestCaptor.getValue();
        assertThat(httpRequest).matches("shouldSearchForTermAndFindResults-request");

        assertThat(results.size()).isEqualTo(0);
    }

    @Test
    public void shouldCallLoginServiceWithCredentialsFromClient() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readFile("torrent-list-no-results.html"));
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        DefaultNcoreClient client = new DefaultNcoreClient("testUser", "testPassword");
        client.setLoginService(loginService);

        client.search("inception");
        verify(loginService, times(1)).login(eq("testUser"), eq("testPassword"));
    }

    @Test
    public void shouldFailedToGetTorrentDetailsWhenItIsCalledWithEmptyTorrentId() throws Exception {
        try {
            ncoreClient.getTorrentDetails(null);
        } catch (Exception e) {
            Assertions.assertThat(e).hasMessage("Torrent id cannot be null.");
        }
    }

    @Test
    public void shouldFindTorrentDetails() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readFile("torrent-details-match.html"));
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        TorrentDetails torrentDetails = ncoreClient.getTorrentDetails("2009695");
        verify(loginService, times(1)).login(eq("username"), eq("password"));

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);
        verify(httpClient, times(1)).execute(requestCaptor.capture());

        HttpUriRequest httpRequest = requestCaptor.getValue();
        assertThat(httpRequest).matches("shouldFindTorrentDetails-request");
        assertThat(torrentDetails).matches("shouldFindTorrentDetails-result");
    }

    @Test
    public void shouldDownloadTorrent() throws Exception {
        String originalContent = readFile("sample.torrent");
        HttpResponse httpResponse = mockHttpResponse(200,
                                                     originalContent,
                                                     null,
                                                     "attachment; filename=\"[nCore][xvid_hun]Inception.2010.BDRip.Xvid.Hun-PpB.torrent\"");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        ncoreClient.download("2009695", TEMP_DIR);
        verify(loginService, times(1)).login(eq("username"), eq("password"));

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);
        verify(httpClient, times(1)).execute(requestCaptor.capture());

        HttpUriRequest httpRequest = requestCaptor.getValue();

        assertThat(httpRequest).matches("shouldDownloadTorrent-request");

        FileInputStream downloadedStream = new FileInputStream(new File(DOWNLOADED_FILE_PATH.toUri()));
        String downloadedContent = IOUtils.toString(downloadedStream, "UTF-8");
        IOUtils.closeQuietly(downloadedStream);

        assertThat(downloadedContent).isEqualTo(originalContent);
    }

    @Test
    public void downloadShouldFailWhenContentDispositionValueIsMissing() throws Exception {
        String originalContent = readFile("sample.torrent");
        HttpResponse httpResponse = mockHttpResponse(200,
                                                     originalContent,
                                                     null,
                                                     "attachment; filename=");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        try {
            ncoreClient.download("2009695", TEMP_DIR);
        } catch (Exception e) {
            Assertions.assertThat(e).hasMessage("Couldn't get filename from header");
        }
    }
}
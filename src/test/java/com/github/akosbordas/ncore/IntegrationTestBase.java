package com.github.akosbordas.ncore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ie.corballis.fixtures.annotation.FixtureAnnotations;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHeader;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.github.akosbordas.ncore.HttpClientProvider.setHttpClient;
import static ie.corballis.fixtures.core.ObjectMapperProvider.getObjectMapper;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegrationTestBase extends TestBase {

    @Mock
    protected HttpClient httpClient;

    protected ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        FixtureAnnotations.initFixtures(this);
        MockitoAnnotations.initMocks(this);
        setHttpClient(httpClient);

        objectMapper = getObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(ByteArrayInputStream.class, new StreamSerializer());
        objectMapper.registerModule(module);
    }
    
    protected HttpResponse mockHttpResponse(int statusCode, String htmlContent, String locationHeaderValue, String contentDisposition) throws IOException {
        HttpResponse httpResponse = mock(HttpResponse.class);
        StatusLine statusLine = mock(StatusLine.class);
        HttpEntity httpEntity = mock(HttpEntity.class);

        when(httpResponse.getLastHeader("location")).thenReturn(new BasicHeader("location", locationHeaderValue));
        when(httpResponse.getFirstHeader("location")).thenReturn(new BasicHeader("location", locationHeaderValue));
        when(httpResponse.getFirstHeader("Content-Disposition")).thenReturn(new BasicHeader("Content-Disposition", contentDisposition));
        when(statusLine.getStatusCode()).thenReturn(statusCode);
        when(httpResponse.getStatusLine()).thenReturn(statusLine);
        when(httpResponse.getEntity()).thenReturn(httpEntity);
        when(httpEntity.getContent()).thenReturn(new ByteArrayInputStream(htmlContent.getBytes(UTF_8)));

        return httpResponse;
    }

    protected HttpResponse mockHttpResponse(int statusCode, String htmlContent, String locationHeaderValue) throws IOException {
        return mockHttpResponse(statusCode, htmlContent, locationHeaderValue, null);
    }

    protected HttpResponse mockHttpResponse(int statusCode, String htmlContent) throws IOException {
        return mockHttpResponse(statusCode, htmlContent, null, null);
    }

}

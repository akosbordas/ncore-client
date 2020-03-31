package com.github.akosbordas.ncore;

import com.github.akosbordas.ncore.authentication.CredentialsProvider;
import com.github.akosbordas.ncore.authentication.LoginService;
import com.github.akosbordas.ncore.search.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.github.akosbordas.ncore.authentication.LoginService.getLoginServiceInstance;
import static com.google.common.collect.Lists.newArrayList;

public class DefaultNcoreClient extends ClientRequestBase implements NcoreClient {

    private static final Logger logger = LoggerFactory.getLogger(DefaultNcoreClient.class);

    public static final String TORRENT_DETAILS_PAGE_PREFIX = "https://ncore.cc/torrents.php?action=details&id=";
    public static final String TORRENT_DOWNLOAD_PAGE_PREFIX = "https://ncore.cc/torrents.php?action=download&id=";
    public static final String TORRENTS_PAGE_PREFIX = "https://ncore.cc/torrents.php";

    private LoginService loginService = getLoginServiceInstance();
    
    private String username;
    private String password;

    public DefaultNcoreClient() {
        this.password = CredentialsProvider.getPassword();
        this.username = CredentialsProvider.getUsername();
    }

    public DefaultNcoreClient(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public List<TorrentListElement> search(String term) throws IOException {
        return search(newArrayList(
                new TextSearchCriterion(term),
                new SearchInCriterion(SearchInCriterion.SEARCH_IN_NAME),
                new OrderByCriterion(OrderByCriterion.ORDER_BY_UPLOAD_DATE)
        ));
    }

    private List<TorrentListElement> search(List<? extends SearchCriterion> criteria) throws IOException {
        logger.debug("Search started with the following criteria: [{}]", criteria);
        loginService.login(username, password);

        List<TorrentListElement> searchResults = newArrayList();

        HttpPost request = new HttpPost(TORRENTS_PAGE_PREFIX);
        initBaseRequestHeaders(request);
        request.setHeader("referer", TORRENTS_PAGE_PREFIX);

        List<NameValuePair> searchFromList = newArrayList();

        String selectedFilters = "";
        for (SearchCriterion searchCriterion : criteria) {
            Map<String, String> searchProperties = searchCriterion.getSearchProperties();
            for (String searchKey : searchProperties.keySet()) {
                if(searchCriterion instanceof TorrentTypeCriterion)
                    selectedFilters += searchProperties.get(searchKey) + ",";
                else
                    searchFromList.add(new BasicNameValuePair(searchKey, searchProperties.get(searchKey)));
            }
        }

        if(selectedFilters.isEmpty()) {
            searchFromList.add(new BasicNameValuePair("tipus", "all_own"));
        } else {
            searchFromList.add(new BasicNameValuePair("tipus", "kivalasztottak_kozott"));
            searchFromList.add(new BasicNameValuePair("kivalasztott_tipus", selectedFilters));
        }

        request.setEntity(new UrlEncodedFormEntity(searchFromList));

        logger.debug("POST request execute is stared to [{}]", TORRENTS_PAGE_PREFIX);
        logger.debug("The following form properties are applied to search [{}]", searchFromList);

        HttpResponse response = HttpClientProvider.getHttpClient().execute(request);

        InputStream contentStream = response.getEntity().getContent();
        Document resultPage = Jsoup.parse(contentStream, "UTF-8", TORRENTS_PAGE_PREFIX);
        contentStream.close();

        logger.debug("Response returned with response code [{}]", response.getStatusLine().getStatusCode());

        for (Element element : resultPage.select("div.torrent_txt > a")) {
            TorrentListElement torrentElement = new TorrentListElement(element.attr("title"), element.attr("href"));
            searchResults.add(torrentElement);
        }

        logger.debug("Search result: [{}]", searchResults);
        return searchResults;
    }

    @Override
    public List<TorrentListElement> search(String term, SearchCriterion... criteria) throws IOException {
        return search(term, newArrayList(criteria));
    }

    @Override
    public List<TorrentListElement> search(String term, List<SearchCriterion> criteria) throws IOException {
        if (criteria == null) {
            criteria = newArrayList();
        }

        boolean hasSearchInCriterion = false;
        boolean hasOrderByCriterion = false;

        for(int i = 0; i < criteria.size(); i++) {
            SearchCriterion criterion = criteria.get(i);

            if(criterion instanceof SearchInCriterion) {
                if(hasSearchInCriterion) criteria.remove(i);
                else hasSearchInCriterion = true;
            }

            else if(criterion instanceof OrderByCriterion) {
                if(hasOrderByCriterion) criteria.remove(i);
                else hasOrderByCriterion = true;
            }
        }

        if(!hasSearchInCriterion)
            criteria.add(new SearchInCriterion(SearchInCriterion.SEARCH_IN_NAME));

        if(!hasOrderByCriterion)
            criteria.add(new OrderByCriterion(OrderByCriterion.ORDER_BY_UPLOAD_DATE));

        criteria.add(new TextSearchCriterion(term));
        return search(criteria);
    }

    public TorrentDetails getTorrentDetails(String torrentId) throws IOException {
        if (torrentId == null) {
            throw new IllegalArgumentException("Torrent id cannot be null.");
        }

        loginService.login(username, password);

        logger.debug("Started to find torrent details for [{}]", torrentId);

        String torrentDetailsUrl = TORRENT_DETAILS_PAGE_PREFIX + torrentId;
        HttpPost request = new HttpPost(torrentDetailsUrl);
        initBaseRequestHeaders(request);
        request.setHeader("referer", torrentDetailsUrl);

        logger.debug("POST request execute is stared to [{}]", torrentDetailsUrl);
        HttpResponse response = HttpClientProvider.getHttpClient().execute(request);

        TorrentDetailsFactory torrentDetailsFactory = TorrentDetailsFactory.getFactoryInstance();

        InputStream contentStream = response.getEntity().getContent();
        TorrentDetails torrentDetails = torrentDetailsFactory.create(IOUtils.toString(contentStream));
        contentStream.close();
        logger.debug("Response returned with response code [{}]", response.getStatusLine().getStatusCode());

        logger.debug("The following torrent details have been found: [{}]", torrentDetails);
        return torrentDetails;
    }

    @Override
    public void download(String torrentId, String path) throws IOException {
        loginService.login(username, password);
        logger.debug("Started to download torrent by [{}] to the following folder [{}]", torrentId, path);

        String downloadPageUrl = TORRENT_DOWNLOAD_PAGE_PREFIX + torrentId;
        HttpGet httpGet = new HttpGet(downloadPageUrl);

        logger.debug("GET request execute is stared to [{}]", downloadPageUrl);
        HttpResponse response = HttpClientProvider.getHttpClient().execute(httpGet);

        String[] contentDispositionValues = response.getFirstHeader("Content-Disposition").getValue().split("\"");
        if (contentDispositionValues.length < 2 || contentDispositionValues[1] == null) {
            throw new RuntimeException("Couldn't get filename from header");
        }

        logger.debug("Response returned with response code [{}]", response.getStatusLine().getStatusCode());

        InputStream contentStream = response.getEntity().getContent();
        FileOutputStream output = new FileOutputStream(new File(path + contentDispositionValues[1]));
        IOUtils.copy(contentStream, output);
        contentStream.close();
        output.close();

        logger.debug("Download finished successfully");
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}

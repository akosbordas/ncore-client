package com.github.akosbordas.ncore;

import com.github.akosbordas.ncore.authentication.LoginService;
import com.github.akosbordas.ncore.search.SearchCriterion;
import com.github.akosbordas.ncore.search.TextSearchCriterion;
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

import java.io.*;
import java.util.List;
import java.util.Map;

import static com.github.akosbordas.ncore.authentication.LoginService.getLoginServiceInstance;
import static com.google.common.collect.Lists.newArrayList;

public class DefaultNcoreClient extends ClientRequestBase implements NcoreClient {

    private LoginService loginService = getLoginServiceInstance();

    public List<TorrentListElement> search(String term) throws IOException {
        return search(newArrayList(new TextSearchCriterion(term)));
    }

    private List<TorrentListElement> search(List<? extends SearchCriterion> criteria) throws IOException {
        loginService.login();

        List<TorrentListElement> searchResults = newArrayList();

        HttpPost request = new HttpPost("https://ncore.cc/torrents.php");
        initBaseRequestHeaders(request);
        request.setHeader("referer", "https://ncore.cc/torrents.php");

        List<NameValuePair> searchFromList = newArrayList();

        for (SearchCriterion searchCriterion : criteria) {
            Map<String, String> searchProperties = searchCriterion.getSearchProperties();
            for (String searchKey : searchProperties.keySet()) {
                searchFromList.add(new BasicNameValuePair(searchKey, searchProperties.get(searchKey)));
            }
        }

        // TODO remove unnecessary parts when this method is finalized
        searchFromList.add(new BasicNameValuePair("miben", "name"));
        searchFromList.add(new BasicNameValuePair("tipus", "all_own"));
        searchFromList.add(new BasicNameValuePair("submit.x", "0"));
        searchFromList.add(new BasicNameValuePair("submit.y", "0"));
        searchFromList.add(new BasicNameValuePair("submit", "Ok"));
        searchFromList.add(new BasicNameValuePair("tags", ""));

        request.setEntity(new UrlEncodedFormEntity(searchFromList));

        HttpResponse response = HttpClientProvider.getHttpClient().execute(request);

        Document resultPage = Jsoup.parse(response.getEntity().getContent(), "UTF-8", "https://ncore.cc/torrents.php");

        for (Element element : resultPage.select("div.torrent_txt > a")) {

            TorrentListElement torrentElement = new TorrentListElement(element.attr("title"), element.attr("href"));

            searchResults.add(torrentElement);

        }

        return searchResults;
    }

    @Override
    public List<TorrentListElement> search(String term, SearchCriterion... criteria) throws IOException {
        return null;
    }

    @Override
    public List<TorrentListElement> search(String term, List<SearchCriterion> criteria) throws IOException {
        return null;
    }

    public TorrentDetails getTorrentDetails(String torrentId) throws IOException {

        if (torrentId == null) {
            throw new NullPointerException("Search term cannot be null.");
        }

        loginService.login();

        HttpPost request = new HttpPost("https://ncore.cc/torrents.php?action=details&id=" + torrentId);
        initBaseRequestHeaders(request);
        request.setHeader("referer", "https://ncore.cc/torrents.php?action=details&id=" + torrentId);

        HttpResponse response = HttpClientProvider.getHttpClient().execute(request);

        TorrentDetailsFactory torrentDetailsFactory = TorrentDetailsFactory.getFactoryInstance();

        return torrentDetailsFactory.create(IOUtils.toString(response.getEntity().getContent()));
    }

    @Override
    public void download(String torrentId, String path) throws IOException {

        loginService.login();
        HttpGet httpGet = new HttpGet("https://ncore.cc/torrents.php?action=download&id=" + torrentId);
        HttpResponse response = HttpClientProvider.getHttpClient().execute(httpGet);

        String[] contentDispositionValues = response.getFirstHeader("Content-Disposition").getValue().split("\"");
        if (contentDispositionValues.length < 2 && contentDispositionValues[1] == null) {
            throw new RuntimeException("Couldn't get filename from header");
        }

        IOUtils.copy(response.getEntity().getContent(), new FileOutputStream(
                new File(path + contentDispositionValues[1]))
        );

    }

}

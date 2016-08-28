package com.github.akosbordas;

import com.github.akosbordas.authentication.LoginService;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

import static com.github.akosbordas.authentication.CredentialsProvider.setPassword;
import static com.github.akosbordas.authentication.CredentialsProvider.setUsername;
import static com.github.akosbordas.HttpClientProvider.getHttpClient;
import static com.github.akosbordas.authentication.LoginService.getLoginServiceInstance;
import static com.google.common.collect.Lists.newArrayList;

public class DefaultNcoreClient extends ClientRequestBase implements NcoreClient {

    private LoginService loginService = getLoginServiceInstance();

    public List<TorrentListElement> search(String term) throws IOException {

        loginService.login();

        List<TorrentListElement> searchResults = newArrayList();

        HttpPost request = new HttpPost("https://ncore.cc/torrents.php");
        initBaseRequestHeaders(request);
        request.setHeader("referer", "https://ncore.cc/torrents.php");

        List<NameValuePair> searchFromList = newArrayList();

        searchFromList.add(new BasicNameValuePair("mire", term));
        searchFromList.add(new BasicNameValuePair("miben", "name"));
        searchFromList.add(new BasicNameValuePair("tipus", "all_own"));
        searchFromList.add(new BasicNameValuePair("submit.x", "0"));
        searchFromList.add(new BasicNameValuePair("submit.y", "0"));
        searchFromList.add(new BasicNameValuePair("submit", "Ok"));
        searchFromList.add(new BasicNameValuePair("tags", ""));

        request.setEntity(new UrlEncodedFormEntity(searchFromList));

        HttpResponse response = getHttpClient().execute(request);

        Document resultPage = Jsoup.parse(response.getEntity().getContent(), "UTF-8", "https://ncore.cc/torrents.php");

        for (Element element : resultPage.select("div.torrent_txt > a")) {

            TorrentListElement torrentElement = new TorrentListElement(element.attr("title"), element.attr("href"));

            searchResults.add(torrentElement);

        }

        return searchResults;

    }

    public TorrentDetails getTorrentDetails(String torrentId) throws IOException {

        if (torrentId == null){
            throw new NullPointerException("Search term cannot be null.");
        }

        loginService.login();

        HttpPost request = new HttpPost("https://ncore.cc/torrents.php?action=details&id=" + torrentId);
        initBaseRequestHeaders(request);
        request.setHeader("referer", "https://ncore.cc/torrents.php?action=details&id=" + torrentId);

        HttpResponse response = getHttpClient().execute(request);

        TorrentDetailsFactory torrentDetailsFactory = TorrentDetailsFactory.getFactoryInstance();

        return torrentDetailsFactory.create(IOUtils.toString(response.getEntity().getContent()));
    }

}

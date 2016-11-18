package com.github.akosbordas.ncore.authentication;

import com.github.akosbordas.ncore.ClientRequestBase;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

import static com.github.akosbordas.ncore.HttpClientProvider.getHttpClient;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Lists.newArrayList;

public class LoginService extends ClientRequestBase {

    private static final String TORRENTS_URL = "https://ncore.cc/torrents.php";
    private static final String LOGIN_URL = "https://ncore.cc/login.php";
    private static final String LOCATION_HEADER = "location";

    private static final LoginService loginServiceInstance = new LoginService();

    private LoginService() {
    }

    public static LoginService getLoginServiceInstance() {
        return loginServiceInstance;

    }

    public boolean isLoggedIn() throws IOException {
        HttpGet request = new HttpGet(TORRENTS_URL);
        HttpResponse response = getHttpClient().execute(request);

        int statusCode = response.getStatusLine().getStatusCode();

        Header locationHeader = response.getLastHeader(LOCATION_HEADER);

        boolean pageContainsLoginContainer = IOUtils.toString(response.getEntity().getContent()).contains("login_all");

        boolean notRedirectedToLoginPage = statusCode == 302 && locationHeader != null && !locationHeader.getValue().contains("login.php");
        boolean isOnLoginPage = statusCode == 200 && pageContainsLoginContainer;

        EntityUtils.consumeQuietly(response.getEntity());

        return notRedirectedToLoginPage || !isOnLoginPage;

    }


    public void login(String username, String password) throws IOException {

        if (isNullOrEmpty(username) || isNullOrEmpty(password)) {
            throw new RuntimeException("Missing credentials. Use CredentialsProvider and set username and password for connection.");
        }

        if (!isLoggedIn()) {

            HttpPost request = new HttpPost(LOGIN_URL);
            initBaseRequestHeaders(request);
            request.setHeader("referer", "https://ncore.cc/login.php");

            List<NameValuePair> loginFormList = newArrayList();

            loginFormList.add(new BasicNameValuePair("set_lang", "hu"));
            loginFormList.add(new BasicNameValuePair("submitted", "1"));
            loginFormList.add(new BasicNameValuePair("nev", username));
            loginFormList.add(new BasicNameValuePair("submit", "Belépés!"));
            loginFormList.add(new BasicNameValuePair("pass", password));

            request.setEntity(new UrlEncodedFormEntity(loginFormList));

            HttpResponse response = getHttpClient().execute(request);

            EntityUtils.consumeQuietly(response.getEntity());

        }

    }

}

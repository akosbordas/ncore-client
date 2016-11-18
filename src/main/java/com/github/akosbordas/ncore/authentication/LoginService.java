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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static com.github.akosbordas.ncore.HttpClientProvider.getHttpClient;
import static com.github.akosbordas.ncore.authentication.CredentialsProvider.getPassword;
import static com.github.akosbordas.ncore.authentication.CredentialsProvider.getUsername;
import static com.google.common.collect.Lists.newArrayList;
import static org.apache.http.util.EntityUtils.consumeQuietly;

public class LoginService extends ClientRequestBase {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    public static final String TORRENTS_URL = "https://ncore.cc/torrents.php";
    public static final String LOGIN_URL = "https://ncore.cc/login.php";
    public static final String LOCATION_HEADER = "location";

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

        boolean redirectsToLoginPage =
            statusCode == 302 && locationHeader != null && locationHeader.getValue().contains("login.php");
        boolean isOnLoginPage = statusCode == 200 && pageContainsLoginContainer;

        consumeQuietly(response.getEntity());

        boolean loggedIn = !isOnLoginPage && !redirectsToLoginPage;
        logger.debug("User was {} logged in previously", loggedIn ? "" : "not");
        return loggedIn;
    }

    public void login() throws IOException {

        if (getUsername() == null || getPassword() == null) {
            throw new RuntimeException("Missing credentials. Use CredentialsProvider and set username and password for connection.");
        }

        if (!isLoggedIn()) {
            logger.debug("User has to be logged in first.");

            HttpPost request = new HttpPost(LOGIN_URL);
            initBaseRequestHeaders(request);
            request.setHeader("referer", LOGIN_URL);

            List<NameValuePair> loginFormList = newArrayList();

            loginFormList.add(new BasicNameValuePair("set_lang", "hu"));
            loginFormList.add(new BasicNameValuePair("submitted", "1"));
            loginFormList.add(new BasicNameValuePair("nev", getUsername()));
            loginFormList.add(new BasicNameValuePair("submit", "Belépés!"));
            loginFormList.add(new BasicNameValuePair("pass", getPassword()));

            request.setEntity(new UrlEncodedFormEntity(loginFormList));

            logger.debug("Login started with username [{}] and password [SECRET]", getUsername());

            logger.debug("POST request execute is stared to [{}]", LOGIN_URL);

            HttpResponse response = getHttpClient().execute(request);
            Header location = response.getFirstHeader("location");

            logger.debug("POST request is finished and redirects to [{}]", location);

            consumeQuietly(response.getEntity());

            if (location == null || location.getValue().contains("problema")) {
                throw new RuntimeException("Failed to login to ncore.cc. Maybe wrong credentials?");
            }

            logger.debug("Login was successful");
        }

    }

}

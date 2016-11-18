package com.github.akosbordas.ncore.authentication;

import com.github.akosbordas.ncore.IntegrationTestBase;
import ie.corballis.fixtures.assertion.FixtureAssert;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LoginServiceTest extends IntegrationTestBase {

    private LoginService loginService;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        loginService = LoginService.getLoginServiceInstance();
    }

    @Test
    public void shouldBeLoggedIn() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(302, readHtml("index-page.html"), "index.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        assertThat(loginService.isLoggedIn()).isTrue();
    }

    @Test
    public void shouldNotBeLoggedInWhenResponseRedirectsBackToLoginPage() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(302, readHtml("login-page.html"), "login.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        assertThat(loginService.isLoggedIn()).isFalse();
    }

    @Test
    public void shouldNotBeLoggedInWhenLandingPageIsTheLoginPageAgain() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readHtml("login-page.html"), "login.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        assertThat(loginService.isLoggedIn()).isFalse();
    }

    @Test(expected = RuntimeException.class)
    public void loginShouldFailWhenNoUsernameProvided() throws Exception {
        CredentialsProvider.setUsername(null);
        loginService.login();
    }

    @Test(expected = RuntimeException.class)
    public void loginShouldFailWhenNoPasswordProvided() throws Exception {
        CredentialsProvider.setUsername("testUser");
        CredentialsProvider.setPassword(null);
        loginService.login();
    }

    @Test
    public void shouldNotCallLoginWhenUserIsAlreadyLoggedIn() throws Exception {
        CredentialsProvider.setUsername("testUser");
        CredentialsProvider.setPassword("testPassword");

        HttpResponse httpResponse = mockHttpResponse(302, readHtml("index-page.html"), "index.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        loginService.login();
        // isLoggedIn is called once
        verify(httpClient, times(1)).execute(any(HttpGet.class));

        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void shouldLoginUser() throws Exception {
        CredentialsProvider.setUsername("testUser");
        CredentialsProvider.setPassword("testPassword");

        HttpResponse loginCheckReponse = mockHttpResponse(200, readHtml("login-page.html"), "login.php");
        HttpResponse loginResponse = mockHttpResponse(200, readHtml("index-page.html"), "index.php");
        when(httpClient.execute(any(HttpUriRequest.class))).thenReturn(loginCheckReponse).thenReturn(loginResponse);

        loginService.login();

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);

        // isLoggedIn and login requests
        verify(httpClient, times(2)).execute(requestCaptor.capture());

        List<HttpUriRequest> allValues = requestCaptor.getAllValues();

        FixtureAssert.assertThat(allValues).matches("shouldLoginUser-requests");
    }

    @Test(expected = RuntimeException.class)
    public void shouldFailWhenProblemOccursDuringTheRequest() throws Exception {
        CredentialsProvider.setUsername("testUser");
        CredentialsProvider.setPassword("testPassword");

        HttpResponse loginCheckReponse = mockHttpResponse(200, readHtml("login-page.html"), "login.php");
        HttpResponse loginResponse = mockHttpResponse(200, readHtml("login-page.html"), "login.php?problema=1");
        when(httpClient.execute(any(HttpUriRequest.class))).thenReturn(loginCheckReponse).thenReturn(loginResponse);

        loginService.login();
    }

}
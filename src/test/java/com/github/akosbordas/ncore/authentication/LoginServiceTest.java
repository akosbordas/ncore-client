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
        HttpResponse httpResponse = mockHttpResponse(302, readFile("index-page.html"), "index.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        assertThat(loginService.isLoggedIn()).isTrue();
    }

    @Test
    public void shouldNotBeLoggedInWhenResponseRedirectsBackToLoginPage() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(302, readFile("login-page.html"), "login.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        assertThat(loginService.isLoggedIn()).isFalse();
    }

    @Test
    public void shouldNotBeLoggedInWhenLandingPageIsTheLoginPageAgain() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(200, readFile("login-page.html"), "login.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
        assertThat(loginService.isLoggedIn()).isFalse();
    }

    @Test(expected = RuntimeException.class)
    public void loginShouldFailWhenNoUsernameProvided() throws Exception {
        loginService.login(null, null);
    }

    @Test(expected = RuntimeException.class)
    public void loginShouldFailWhenNoPasswordProvided() throws Exception {
        loginService.login("testUser", null);
    }

    @Test
    public void shouldNotCallLoginWhenUserIsAlreadyLoggedIn() throws Exception {
        HttpResponse httpResponse = mockHttpResponse(302, readFile("index-page.html"), "index.php");
        when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);

        loginService.login("testUser", "testPassword");
        // isLoggedIn is called once
        verify(httpClient, times(1)).execute(any(HttpGet.class));

        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void shouldLoginUser() throws Exception {
        HttpResponse loginCheckReponse = mockHttpResponse(200, readFile("login-page.html"), "login.php");
        HttpResponse loginResponse = mockHttpResponse(200, readFile("index-page.html"), "index.php");
        when(httpClient.execute(any(HttpUriRequest.class))).thenReturn(loginCheckReponse).thenReturn(loginResponse);

        loginService.login("testUser", "testPassword");

        ArgumentCaptor<HttpUriRequest> requestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);

        // isLoggedIn and login requests
        verify(httpClient, times(2)).execute(requestCaptor.capture());

        List<HttpUriRequest> allValues = requestCaptor.getAllValues();

        FixtureAssert.assertThat(allValues).matches("shouldLoginUser-requests");
    }

    @Test(expected = RuntimeException.class)
    public void shouldFailWhenProblemOccursDuringTheRequest() throws Exception {
        HttpResponse loginCheckReponse = mockHttpResponse(200, readFile("login-page.html"), "login.php");
        HttpResponse loginResponse = mockHttpResponse(200, readFile("login-page.html"), "login.php?problema=1");
        when(httpClient.execute(any(HttpUriRequest.class))).thenReturn(loginCheckReponse).thenReturn(loginResponse);

        loginService.login("testUser", "testPassword");
    }

}
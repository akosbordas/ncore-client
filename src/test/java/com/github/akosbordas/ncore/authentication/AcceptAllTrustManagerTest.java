package com.github.akosbordas.ncore.authentication;

import org.junit.Test;

import java.security.cert.X509Certificate;

import static org.fest.assertions.api.Assertions.assertThat;

public class AcceptAllTrustManagerTest {

    private AcceptAllTrustManager trustManager = new AcceptAllTrustManager();

    @Test
    public void shouldDoNothing() throws Exception {
        assertThat(trustManager.getAcceptedIssuers()).isNull();
        String arg1 = "";
        X509Certificate[] certificates = new X509Certificate[0];

        trustManager.checkClientTrusted(certificates, arg1);
        trustManager.checkServerTrusted(certificates, arg1);

        assertThat(arg1).isEqualTo(arg1);
        assertThat(certificates).isEqualTo(certificates);
    }
}
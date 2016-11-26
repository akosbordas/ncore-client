package com.github.akosbordas.ncore.authentication;

import org.junit.After;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CredentialsProviderTest {

    @After
    public void tearDown() throws Exception {
        CredentialsProvider.setPassword(null);
        CredentialsProvider.setUsername(null);
    }

    @Test
    public void shouldInitCredentials() throws Exception {
        CredentialsProvider credentialsProvider = new CredentialsProvider();
        assertThat(CredentialsProvider.getPassword()).isNull();
        assertThat(CredentialsProvider.getUsername()).isNull();

        credentialsProvider.setUsername("test");
        credentialsProvider.setPassword("test");

        assertThat(CredentialsProvider.getPassword()).isEqualTo("test");
        assertThat(CredentialsProvider.getUsername()).isEqualTo("test");

    }
}
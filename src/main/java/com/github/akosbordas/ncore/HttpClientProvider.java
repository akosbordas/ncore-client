package com.github.akosbordas.ncore;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientProvider {

    private static HttpClient httpClient;

    static {
        httpClient = HttpClientBuilder.create().build();
    }

    public synchronized static void setHttpClient(HttpClient httpClient) {
        HttpClientProvider.httpClient = httpClient;
    }

    public synchronized static HttpClient getHttpClient() {
        return httpClient;
    }
}

package com.github.akosbordas.ncore;

import com.github.akosbordas.ncore.authentication.AcceptAllTrustManager;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Throwables.propagate;

public class HttpClientProvider {

    private static HttpClient httpClient;

    static {
        httpClient = createHttpClient();
    }

    public synchronized static void setHttpClient(HttpClient httpClient) {
        HttpClientProvider.httpClient = httpClient;
    }

    public synchronized static HttpClient getHttpClient() {
        return httpClient;
    }

    private static SSLContext getSslContext() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] {new AcceptAllTrustManager()}, new SecureRandom());
            return ctx;
        } catch (Exception e) {
            propagate(e);
        }
        return null;
    }

    private static HttpClient createHttpClient() {
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(getSslContext(),
                                                                                               new String[] {"TLSv1",
                                                                                                             "SSLv3"},
                                                                                               null,
                                                                                               SSLConnectionSocketFactory
                                                                                                   .getDefaultHostnameVerifier());

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                                                                                 .register("http",
                                                                                           PlainConnectionSocketFactory.INSTANCE)
                                                                                 .register("https",
                                                                                           sslConnectionSocketFactory)
                                                                                 .build();
        PoolingHttpClientConnectionManager connectionManager =
            new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        return HttpClients.custom()
                          .setSSLSocketFactory(sslConnectionSocketFactory)
                          .setConnectionManager(connectionManager)
                          .build();
    }

}

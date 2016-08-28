package com.github.akosbordas;

import org.apache.http.client.methods.HttpPost;

public abstract class ClientRequestBase {

    public void initBaseRequestHeaders(HttpPost request){
        request.setHeader("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        request.setHeader("accept-encoding", "gzip, deflate, br");
        request.setHeader("accept-language", "hu-HU,hu;q=0.8,en-US;q=0.6,en;q=0.4");
        request.setHeader("cache-control", "max-age=0");
        request.setHeader("content-type", "application/x-www-form-urlencoded");
        request.setHeader("origin", "https://ncore.cc");
        request.setHeader("upgrade-insecure-requests", "1");
        request.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
    }

}

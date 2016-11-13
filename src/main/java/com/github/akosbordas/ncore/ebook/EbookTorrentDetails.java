package com.github.akosbordas.ncore.ebook;

import com.github.akosbordas.ncore.TorrentDetails;
import org.jsoup.nodes.Document;

public class EbookTorrentDetails extends TorrentDetails {

    public String getTags() {
        return tags;
    }

    private String tags;

    @Override
    public void customParse(Document document) {
        tags = extractTypeSpecificInfoByName(document, "Címkék");
    }

    @Override
    public String toString() {
        return "EbookTorrentDetails{" +
                "tags='" + tags + '\'' +
                '}';
    }
}
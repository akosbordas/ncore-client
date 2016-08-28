package com.github.akosbordas.ebook;

import com.github.akosbordas.TorrentDetails;
import org.jsoup.nodes.Document;

public class EbookTorrentDetails extends TorrentDetails {

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

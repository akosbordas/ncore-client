package com.github.akosbordas.music;

import com.github.akosbordas.TorrentDetails;
import org.jsoup.nodes.Document;

public class MusicTorrentDetails extends TorrentDetails {

    public String getTags() {
        return tags;
    }

    private String tags;

    public void customParse(Document document) {

        tags = extractTypeSpecificInfoByName(document, "Címkék");


    }

    @Override
    public String toString() {
        return super.toString() + "tags='" + tags + '\'';
    }
}

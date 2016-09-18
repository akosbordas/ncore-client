package com.github.akosbordas;

import java.io.IOException;
import java.util.List;

public interface NcoreClient {

    List<TorrentListElement> search(String term) throws IOException;
    TorrentDetails getTorrentDetails(String torrentId) throws IOException;

    void download(String torrentId, String path) throws IOException;

}

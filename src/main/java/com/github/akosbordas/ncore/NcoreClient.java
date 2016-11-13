package com.github.akosbordas.ncore;

import com.github.akosbordas.ncore.search.SearchCriterion;

import java.io.IOException;
import java.util.List;

public interface NcoreClient {

    List<TorrentListElement> search(String term) throws IOException;

    List<TorrentListElement> search(String term, SearchCriterion... criteria) throws IOException;

    List<TorrentListElement> search(String term, List<SearchCriterion> criteria) throws IOException;

    TorrentDetails getTorrentDetails(String torrentId) throws IOException;

    void download(String torrentId, String path) throws IOException;

}

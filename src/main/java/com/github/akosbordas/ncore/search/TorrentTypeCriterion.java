package com.github.akosbordas.ncore.search;

import com.github.akosbordas.ncore.TorrentType;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class TorrentTypeCriterion implements SearchCriterion {

    private TorrentType torrentType;

    public TorrentTypeCriterion(TorrentType torrentType) {
        this.torrentType = torrentType;
    }

    @Override
    public Map<String, String> getSearchProperties() {
        Map<String, String> properties = newHashMap();
        if (torrentType.isEnglish()) {
            properties.put(torrentType.getSearchKeyForType(), torrentType.getSearchValue());
        } else {
            properties.put(torrentType.getSearchKeyForType(), torrentType.getSearchValue() + "_hun");
        }
        return properties;
    }

}

package com.github.akosbordas.ncore.search;

import com.github.akosbordas.ncore.TorrentType;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TorrentTypeCriterion that = (TorrentTypeCriterion) o;
        return Objects.equals(torrentType, that.torrentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(torrentType);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TorrentTypeCriterion{");
        sb.append("torrentType=").append(torrentType);
        sb.append('}');
        return sb.toString();
    }
}

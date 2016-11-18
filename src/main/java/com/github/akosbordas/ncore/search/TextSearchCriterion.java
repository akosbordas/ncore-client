package com.github.akosbordas.ncore.search;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class TextSearchCriterion implements SearchCriterion {

    private String term;

    public TextSearchCriterion(String term) {
        this.term = term;
    }

    @Override
    public Map<String, String> getSearchProperties() {
        Map<String, String> properties = newHashMap();
        properties.put("mire", term);
        return properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TextSearchCriterion{");
        sb.append("term='").append(term).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

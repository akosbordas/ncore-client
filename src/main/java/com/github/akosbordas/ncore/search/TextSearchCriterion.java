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
}

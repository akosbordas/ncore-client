package com.github.akosbordas.ncore.search;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class SearchInCriterion implements SearchCriterion {

    public static final String SEARCH_IN_NAME = "name";
    public static final String SEARCH_IN_DESCRIPTION = "leiras";
    public static final String SEARCH_IN_IMDB = "imdb";
    public static final String SEARCH_IN_UPLOADER = "uploaded_by_nev";
    public static final String SEARCH_IN_LABEL = "cimke";


    private String value;

    public SearchInCriterion(String value) {
        this.value = value;
    }

    @Override
    public Map<String, String> getSearchProperties() {
        Map<String, String> properties = newHashMap();
        properties.put("miben", value);
        return properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchInCriterion{");
        sb.append("value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

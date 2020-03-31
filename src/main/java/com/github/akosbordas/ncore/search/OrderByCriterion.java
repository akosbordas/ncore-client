package com.github.akosbordas.ncore.search;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class OrderByCriterion implements SearchCriterion {

    public static final String ORDER_BY_NAME = "name";
    public static final String ORDER_BY_UPLOAD_DATE = "fid";
    public static final String ORDER_BY_SIZE = "size";
    public static final String ORDER_BY_DOWNLOADS = "times_completed";
    public static final String ORDER_BY_SEEDERS = "seeders";
    public static final String ORDER_BY_LEECHERS = "leechers";

    private String value;
    private boolean desc;

    public OrderByCriterion(String value) {
        this.value = value;
    }

    public OrderByCriterion(String value, boolean desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Map<String, String> getSearchProperties() {
        Map<String, String> properties = newHashMap();
        properties.put("miszerint", value);
        properties.put("hogyan", (desc ? "DESC" : "ASC"));
        return properties;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderByCriterion{");
        sb.append("value='").append(value).append('\'');
        sb.append("desc='").append(desc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

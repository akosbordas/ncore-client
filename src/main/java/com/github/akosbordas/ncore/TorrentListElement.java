package com.github.akosbordas.ncore;

public class TorrentListElement {

    private String name;
    private String url;

    public TorrentListElement(String name, String url) {
        this.name = name;
        this.url = "https://ncore.cc/" + url;
    }

    public String getId() {
        return url.substring(48);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = "https://ncore.cc/" + url;
    }

    @Override
    public String toString() {
        return "\nTorrentListElement{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TorrentListElement that = (TorrentListElement) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}

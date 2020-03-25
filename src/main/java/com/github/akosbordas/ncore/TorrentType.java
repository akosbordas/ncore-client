package com.github.akosbordas.ncore;

public class TorrentType {

    public static final String MOVIE_SD = "xvid";
    public static final String MOVIE_DVD = "dvd";
    public static final String MOVIE_DVD9 = "dvd9";
    public static final String MOVIE_HD = "hd";
    public static final String SERIES_SD = "xvidser";
    public static final String SERIES_DVD = "dvdser";
    public static final String SERIES_HD = "hdser";
    public static final String MUSIC_MP3 = "mp3";
    public static final String MUSIC_LOSSLESS = "lossless";
    public static final String MUSIC_CLIP = "clip";
    public static final String GAME_ISO = "game_iso";
    public static final String GAME_RIP = "game_rip";
    public static final String GAME_CONSOLE = "console";
    public static final String E_BOOK = "ebook";
    public static final String PROGRAM_RIP = "misc";
    public static final String PROGRAM_ISO = "iso";
    public static final String PROGRAM_MOBILE = "mobil";
    public static final String XXX_SD = "xxx_xvid";
    public static final String XXX_DVD = "xxx_dvd";
    public static final String XXX_IMAGESET = "xxx_imageset";
    public static final String XXX_HD = "xxx_hd";

    private String searchValue;
    private boolean english;

    public TorrentType(String searchValue) {
        this.searchValue = searchValue;
    }

    public TorrentType(String searchValue, boolean english) {
        this.searchValue = searchValue;
        this.english = english;
    }

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getSearchKeyForType() {
        return "kivalasztott_tipus[]";
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TorrentType)) return false;

        TorrentType other = (TorrentType) obj;

        return (getSearchValue().equals(other.getSearchValue()) && isEnglish() == other.isEnglish());
    }
}

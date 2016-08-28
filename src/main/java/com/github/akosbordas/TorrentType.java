package com.github.akosbordas;

public enum TorrentType {
    MOVIE_SD,
    MOVIE_DVD,
    MOVIE_DVD9,
    MOVIE_HD,
    SERIES_SD,
    SERIES_DVD,
    SERIES_HD,
    MUSIC_MP3,
    MUSIC_LOSSLESS,
    MUSIC_CLIP,
    GAME_ISO,
    GAME_RIP,
    GAME_CONSOLE,
    E_BOOK,
    PROGRAM_RIP,
    PROGRAM_ISO,
    PROGRAM_MOBILE,
    XXX_SD,
    XXX_DVD,
    XXX_IMAGESET,
    XXX_HD;

    private boolean english;

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }
}

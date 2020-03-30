package com.github.akosbordas.ncore.search;

import com.github.akosbordas.ncore.TorrentType;

import static com.github.akosbordas.ncore.TorrentType.*;

public class CriteriaFactory {

    public static TorrentTypeCriterion sdMovie() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_SD, false));
    }

    public static TorrentTypeCriterion sdMovieEn() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_SD, true));
    }

    public static TorrentTypeCriterion dvdMovie() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_DVD, false));
    }

    public static TorrentTypeCriterion dvdMovieEn() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_DVD, true));
    }

    public static TorrentTypeCriterion dvd9Movie() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_DVD9, false));
    }

    public static TorrentTypeCriterion dvd9MovieEn() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_DVD9, true));
    }

    public static TorrentTypeCriterion hdMovie() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_HD, false));
    }

    public static TorrentTypeCriterion hdMovieEn() {
        return new TorrentTypeCriterion(new TorrentType(MOVIE_HD, true));
    }

    public static TorrentTypeCriterion sdSeries() {
        return new TorrentTypeCriterion(new TorrentType(SERIES_SD, false));
    }

    public static TorrentTypeCriterion sdSeriesEn() {
        return new TorrentTypeCriterion(new TorrentType(SERIES_SD, true));
    }

    public static TorrentTypeCriterion dvdSeries() {
        return new TorrentTypeCriterion(new TorrentType(SERIES_DVD, false));
    }

    public static TorrentTypeCriterion dvdSeriesEn() {
        return new TorrentTypeCriterion(new TorrentType(SERIES_DVD, true));
    }

    public static TorrentTypeCriterion hdSeries() {
        return new TorrentTypeCriterion(new TorrentType(SERIES_HD, false));
    }

    public static TorrentTypeCriterion hdSeriesEn() {
        return new TorrentTypeCriterion(new TorrentType(SERIES_HD, true));
    }

    public static TorrentTypeCriterion mp3Music() {
        return new TorrentTypeCriterion(new TorrentType(MUSIC_MP3, false));
    }

    public static TorrentTypeCriterion mp3MusicEn() {
        return new TorrentTypeCriterion(new TorrentType(MUSIC_MP3, true));
    }

    public static TorrentTypeCriterion losslessMusic() {
        return new TorrentTypeCriterion(new TorrentType(MUSIC_LOSSLESS, false));
    }

    public static TorrentTypeCriterion losslessMusicEn() {
        return new TorrentTypeCriterion(new TorrentType(MUSIC_LOSSLESS, true));
    }

    public static TorrentTypeCriterion musicClip() {
        return new TorrentTypeCriterion(new TorrentType(MUSIC_CLIP, true));
    }

    public static TorrentTypeCriterion isoGame() {
        return new TorrentTypeCriterion(new TorrentType(GAME_ISO, true));
    }

    public static TorrentTypeCriterion ripGame() {
        return new TorrentTypeCriterion(new TorrentType(GAME_RIP, true));
    }

    public static TorrentTypeCriterion consoleGame() {
        return new TorrentTypeCriterion(new TorrentType(GAME_CONSOLE, true));
    }

    public static TorrentTypeCriterion ebook() {
        return new TorrentTypeCriterion(new TorrentType(E_BOOK, false));
    }

    public static TorrentTypeCriterion ebookEn() {
        return new TorrentTypeCriterion(new TorrentType(E_BOOK, true));
    }

    public static TorrentTypeCriterion ripProgram() {
        return new TorrentTypeCriterion(new TorrentType(PROGRAM_RIP, true));
    }

    public static TorrentTypeCriterion isoProgram() {
        return new TorrentTypeCriterion(new TorrentType(PROGRAM_ISO, true));
    }

    public static TorrentTypeCriterion mobileProgram() {
        return new TorrentTypeCriterion(new TorrentType(PROGRAM_MOBILE, true));
    }

    public static TorrentTypeCriterion sdXxx() {
        return new TorrentTypeCriterion(new TorrentType(XXX_SD, true));
    }

    public static TorrentTypeCriterion dvdXxx() {
        return new TorrentTypeCriterion(new TorrentType(XXX_DVD, true));
    }

    public static TorrentTypeCriterion imageSetXxx() {
        return new TorrentTypeCriterion(new TorrentType(XXX_IMAGESET, true));
    }

    public static TorrentTypeCriterion hdXxx() {
        return new TorrentTypeCriterion(new TorrentType(XXX_HD, true));
    }

    public static SearchInCriterion searchInName() {
        return new SearchInCriterion(SearchInCriterion.SEARCH_IN_NAME);
    }

    public static SearchInCriterion searchInDescription() {
        return new SearchInCriterion(SearchInCriterion.SEARCH_IN_DESCRIPTION);
    }

    public static SearchInCriterion searchInImdb() {
        return new SearchInCriterion(SearchInCriterion.SEARCH_IN_IMDB);
    }

    public static SearchInCriterion searchInUploader() {
        return new SearchInCriterion(SearchInCriterion.SEARCH_IN_UPLOADER);
    }

    public static SearchInCriterion searchInLabel() {
        return new SearchInCriterion(SearchInCriterion.SEARCH_IN_LABEL);
    }

}

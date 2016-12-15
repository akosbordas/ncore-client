package com.github.akosbordas.ncore.search;

import com.github.akosbordas.ncore.TorrentType;

import static com.github.akosbordas.ncore.TorrentType.*;

public class CriteriaFactory {

    public static TorrentTypeCriterion sdMovie() {
        return new TorrentTypeCriterion(MOVIE_SD);
    }

    public static TorrentTypeCriterion sdMovieEn() {
        TorrentType type = MOVIE_SD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion dvdMovie() {
        return new TorrentTypeCriterion(MOVIE_DVD);
    }

    public static TorrentTypeCriterion dvdMovieEn() {
        TorrentType type = MOVIE_DVD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion dvd9Movie() {
        return new TorrentTypeCriterion(MOVIE_DVD9);
    }

    public static TorrentTypeCriterion dvd9MovieEn() {
        TorrentType type = MOVIE_DVD9;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion hdMovie() {
        return new TorrentTypeCriterion(TorrentType.MOVIE_HD);
    }

    public static TorrentTypeCriterion hdMovieEn() {
        TorrentType type = TorrentType.MOVIE_HD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion sdSeries() {
        return new TorrentTypeCriterion(SERIES_SD);
    }

    public static TorrentTypeCriterion sdSeriesEn() {
        TorrentType type = SERIES_SD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion dvdSeries() {
        return new TorrentTypeCriterion(SERIES_DVD);
    }

    public static TorrentTypeCriterion dvdSeriesEn() {
        TorrentType type = SERIES_DVD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion hdSeries() {
        return new TorrentTypeCriterion(SERIES_HD);
    }

    public static TorrentTypeCriterion hdSeriesEn() {
        TorrentType type = SERIES_HD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion mp3Music() {
        return new TorrentTypeCriterion(MUSIC_MP3);
    }

    public static TorrentTypeCriterion mp3MusicEn() {
        TorrentType type = MUSIC_MP3;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion losslessMusic() {
        return new TorrentTypeCriterion(MUSIC_LOSSLESS);
    }

    public static TorrentTypeCriterion losslessMusicEn() {
        TorrentType type = MUSIC_LOSSLESS;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion musicClip() {
        return new TorrentTypeCriterion(MUSIC_CLIP);
    }

    public static TorrentTypeCriterion musicClipEn() {
        TorrentType type = MUSIC_CLIP;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion isoGame() {
        return new TorrentTypeCriterion(GAME_ISO);
    }

    public static TorrentTypeCriterion isoGameEn() {
        TorrentType type = GAME_ISO;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion ripGame() {
        return new TorrentTypeCriterion(GAME_RIP);
    }

    public static TorrentTypeCriterion ripGameEn() {
        TorrentType type = GAME_RIP;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion consoleGame() {
        return new TorrentTypeCriterion(GAME_CONSOLE);
    }

    public static TorrentTypeCriterion consoleGameEn() {
        TorrentType type = GAME_CONSOLE;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion ebook() {
        return new TorrentTypeCriterion(E_BOOK);
    }

    public static TorrentTypeCriterion ebookEn() {
        TorrentType type = E_BOOK;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion ripProgram() {
        return new TorrentTypeCriterion(PROGRAM_RIP);
    }

    public static TorrentTypeCriterion ripProgramEn() {
        TorrentType type = PROGRAM_RIP;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion isoProgram() {
        return new TorrentTypeCriterion(PROGRAM_ISO);
    }

    public static TorrentTypeCriterion isoProgramEn() {
        TorrentType type = PROGRAM_ISO;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion mobileProgram() {
        return new TorrentTypeCriterion(PROGRAM_MOBILE);
    }

    public static TorrentTypeCriterion mobileProgramEn() {
        TorrentType type = PROGRAM_MOBILE;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion sdXxx() {
        return new TorrentTypeCriterion(XXX_SD);
    }

    public static TorrentTypeCriterion sdXxxEn() {
        TorrentType type = XXX_SD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion dvdXxx() {
        return new TorrentTypeCriterion(XXX_DVD);
    }

    public static TorrentTypeCriterion dvdXxxEn() {
        TorrentType type = XXX_DVD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion imageSetXxx() {
        return new TorrentTypeCriterion(XXX_IMAGESET);
    }

    public static TorrentTypeCriterion imageSetXxxEn() {
        TorrentType type = XXX_IMAGESET;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

    public static TorrentTypeCriterion hdXxx() {
        return new TorrentTypeCriterion(XXX_HD);
    }

    public static TorrentTypeCriterion hdXxxEn() {
        TorrentType type = XXX_HD;
        type.setEnglish(true);
        return new TorrentTypeCriterion(type);
    }

}

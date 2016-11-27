package com.github.akosbordas.ncore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class TorrentTypeTest {

    @Test
    public void sdMovieShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.MOVIE_SD.getSearchValue()).isEqualTo("xvid");
        assertThat(TorrentType.MOVIE_SD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void dvdMovieShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.MOVIE_DVD.getSearchValue()).isEqualTo("dvd");
        assertThat(TorrentType.MOVIE_DVD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void dvd9MovieShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.MOVIE_DVD9.getSearchValue()).isEqualTo("dvd9");
        assertThat(TorrentType.MOVIE_DVD9.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void hdMovieShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.MOVIE_HD.getSearchValue()).isEqualTo("hd");
        assertThat(TorrentType.MOVIE_HD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void sdSeriesShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.SERIES_SD.getSearchValue()).isEqualTo("xvidser");
        assertThat(TorrentType.SERIES_SD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void dvdSeriesShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.SERIES_DVD.getSearchValue()).isEqualTo("dvdser");
        assertThat(TorrentType.SERIES_DVD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void hdSeriesShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.SERIES_HD.getSearchValue()).isEqualTo("hdser");
        assertThat(TorrentType.SERIES_HD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void mp3MusicShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.MUSIC_MP3.getSearchValue()).isEqualTo("mp3");
        assertThat(TorrentType.MUSIC_MP3.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void losslessMusicShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.MUSIC_LOSSLESS.getSearchValue()).isEqualTo("lossless");
        assertThat(TorrentType.MUSIC_LOSSLESS.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void musicClipShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.MUSIC_CLIP.getSearchValue()).isEqualTo("clip");
        assertThat(TorrentType.MUSIC_CLIP.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void gameIsoShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.GAME_ISO.getSearchValue()).isEqualTo("game_iso");
        assertThat(TorrentType.GAME_ISO.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void gameRipShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.GAME_RIP.getSearchValue()).isEqualTo("game_rip");
        assertThat(TorrentType.GAME_RIP.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void gameConsoleShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.GAME_CONSOLE.getSearchValue()).isEqualTo("console");
        assertThat(TorrentType.GAME_CONSOLE.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void ebookShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.E_BOOK.getSearchValue()).isEqualTo("ebook");
        assertThat(TorrentType.E_BOOK.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void programRipShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.PROGRAM_RIP.getSearchValue()).isEqualTo("misc");
        assertThat(TorrentType.PROGRAM_RIP.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void programIsoShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.PROGRAM_ISO.getSearchValue()).isEqualTo("iso");
        assertThat(TorrentType.PROGRAM_ISO.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void programMobileShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.PROGRAM_MOBILE.getSearchValue()).isEqualTo("mobil");
        assertThat(TorrentType.PROGRAM_MOBILE.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxSdShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.XXX_SD.getSearchValue()).isEqualTo("xxx_xvid");
        assertThat(TorrentType.XXX_SD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxDvdShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.XXX_DVD.getSearchValue()).isEqualTo("xxx_dvd");
        assertThat(TorrentType.XXX_DVD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxImageSetShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.XXX_IMAGESET.getSearchValue()).isEqualTo("xxx_imageset");
        assertThat(TorrentType.XXX_IMAGESET.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxHdShouldHaveProperSearchValue() throws Exception {
        assertThat(TorrentType.XXX_HD.getSearchValue()).isEqualTo("xxx_hd");
        assertThat(TorrentType.XXX_HD.getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void englishTypeShouldBeSer() throws Exception {
        TorrentType movieSd = TorrentType.MOVIE_SD;
        movieSd.setEnglish(true);
        assertThat(movieSd.isEnglish()).isTrue();
    }
}
package com.github.akosbordas.ncore;

import org.junit.Test;

import static com.github.akosbordas.ncore.TorrentType.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class TorrentTypeTest {

    @Test
    public void sdMovieShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(MOVIE_SD).getSearchValue()).isEqualTo("xvid");
        assertThat(new TorrentType(MOVIE_SD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void dvdMovieShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(MOVIE_DVD).getSearchValue()).isEqualTo("dvd");
        assertThat(new TorrentType(MOVIE_DVD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void dvd9MovieShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(MOVIE_DVD9).getSearchValue()).isEqualTo("dvd9");
        assertThat(new TorrentType(MOVIE_DVD9).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void hdMovieShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(MOVIE_HD).getSearchValue()).isEqualTo("hd");
        assertThat(new TorrentType(MOVIE_HD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void sdSeriesShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(SERIES_SD).getSearchValue()).isEqualTo("xvidser");
        assertThat(new TorrentType(SERIES_SD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void dvdSeriesShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(SERIES_DVD).getSearchValue()).isEqualTo("dvdser");
        assertThat(new TorrentType(SERIES_DVD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void hdSeriesShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(SERIES_HD).getSearchValue()).isEqualTo("hdser");
        assertThat(new TorrentType(SERIES_HD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void mp3MusicShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(MUSIC_MP3).getSearchValue()).isEqualTo("mp3");
        assertThat(new TorrentType(MUSIC_MP3).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void losslessMusicShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(MUSIC_LOSSLESS).getSearchValue()).isEqualTo("lossless");
        assertThat(new TorrentType(MUSIC_LOSSLESS).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void musicClipShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(MUSIC_CLIP).getSearchValue()).isEqualTo("clip");
        assertThat(new TorrentType(MUSIC_CLIP).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void gameIsoShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(GAME_ISO).getSearchValue()).isEqualTo("game_iso");
        assertThat(new TorrentType(GAME_ISO).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void gameRipShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(GAME_RIP).getSearchValue()).isEqualTo("game_rip");
        assertThat(new TorrentType(GAME_RIP).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void gameConsoleShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(GAME_CONSOLE).getSearchValue()).isEqualTo("console");
        assertThat(new TorrentType(GAME_CONSOLE).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void ebookShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(E_BOOK).getSearchValue()).isEqualTo("ebook");
        assertThat(new TorrentType(E_BOOK).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void programRipShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(PROGRAM_RIP).getSearchValue()).isEqualTo("misc");
        assertThat(new TorrentType(PROGRAM_RIP).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void programIsoShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(PROGRAM_ISO).getSearchValue()).isEqualTo("iso");
        assertThat(new TorrentType(PROGRAM_ISO).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void programMobileShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(PROGRAM_MOBILE).getSearchValue()).isEqualTo("mobil");
        assertThat(new TorrentType(PROGRAM_MOBILE).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxSdShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(XXX_SD).getSearchValue()).isEqualTo("xxx_xvid");
        assertThat(new TorrentType(XXX_SD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxDvdShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(XXX_DVD).getSearchValue()).isEqualTo("xxx_dvd");
        assertThat(new TorrentType(XXX_DVD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxImageSetShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(XXX_IMAGESET).getSearchValue()).isEqualTo("xxx_imageset");
        assertThat(new TorrentType(XXX_IMAGESET).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void xxxHdShouldHaveProperSearchValue() throws Exception {
        assertThat(new TorrentType(XXX_HD).getSearchValue()).isEqualTo("xxx_hd");
        assertThat(new TorrentType(XXX_HD).getSearchKeyForType()).isEqualTo("kivalasztott_tipus[]");
    }

    @Test
    public void englishTypeShouldBeSer() throws Exception {
        TorrentType movieSd = new TorrentType(MOVIE_SD);
        movieSd.setEnglish(true);
        assertThat(movieSd.isEnglish()).isTrue();
    }

    @Test
    public void equalsShouldBeCorrect() {
        assertThat(new TorrentType(null, false)).isEqualTo(new TorrentType(null, false));
    }
}
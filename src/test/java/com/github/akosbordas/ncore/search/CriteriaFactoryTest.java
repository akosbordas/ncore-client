package com.github.akosbordas.ncore.search;

import com.github.akosbordas.ncore.TorrentType;
import org.junit.Before;
import org.junit.Test;

import static com.github.akosbordas.ncore.TorrentType.*;
import static com.github.akosbordas.ncore.search.CriteriaFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CriteriaFactoryTest {

    @Test
    public void testSdMovie() throws Exception {
        assertThat(sdMovie()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_SD, false)));
    }

    @Test
    public void testSdMovieEn() throws Exception {
        assertThat(sdMovieEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_SD, true)));
    }

    @Test
    public void testDvdMovie() throws Exception {
        assertThat(dvdMovie()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_DVD, false)));
    }

    @Test
    public void testDvdMovieEn() throws Exception {
        assertThat(dvdMovieEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_DVD, true)));
    }

    @Test
    public void testDvd9Movie() throws Exception {
        assertThat(dvd9Movie()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_DVD9, false)));
    }

    @Test
    public void testDvd9MovieEn() throws Exception {
        assertThat(dvd9MovieEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_DVD9, true)));
    }

    @Test
    public void testHdMovie() throws Exception {
        assertThat(hdMovie()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_HD, false)));
    }

    @Test
    public void testHdMovieEn() throws Exception {
        assertThat(hdMovieEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MOVIE_HD, true)));
    }

    @Test
    public void testSdSeries() throws Exception {
        assertThat(sdSeries()).isEqualTo(new TorrentTypeCriterion(new TorrentType(SERIES_SD, false)));
    }

    @Test
    public void testSdSeriesEn() throws Exception {
        assertThat(sdSeriesEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(SERIES_SD, true)));
    }

    @Test
    public void testDvdSeries() throws Exception {
        assertThat(dvdSeries()).isEqualTo(new TorrentTypeCriterion(new TorrentType(SERIES_DVD, false)));
    }

    @Test
    public void testDvdSeriesEn() throws Exception {
        assertThat(dvdSeriesEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(SERIES_DVD, true)));
    }

    @Test
    public void testHdSeries() throws Exception {
        assertThat(hdSeries()).isEqualTo(new TorrentTypeCriterion(new TorrentType(SERIES_HD, false)));
    }

    @Test
    public void testHdSeriesEn() throws Exception {
        assertThat(hdSeriesEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(SERIES_HD, true)));
    }

    @Test
    public void testMp3Music() throws Exception {
        assertThat(mp3Music()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MUSIC_MP3, false)));
    }

    @Test
    public void testMp3MusicEn() throws Exception {
        assertThat(mp3MusicEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MUSIC_MP3, true)));
    }

    @Test
    public void testLosslessMusic() throws Exception {
        assertThat(losslessMusic()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MUSIC_LOSSLESS, false)));
    }

    @Test
    public void testLosslessMusicEn() throws Exception {
        assertThat(losslessMusicEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MUSIC_LOSSLESS, true)));
    }

    @Test
    public void testMusicClip() throws Exception {
        assertThat(musicClip()).isEqualTo(new TorrentTypeCriterion(new TorrentType(MUSIC_CLIP, true)));
    }

    @Test
    public void testIsoGame() throws Exception {
        assertThat(isoGame()).isEqualTo(new TorrentTypeCriterion(new TorrentType(GAME_ISO, true)));
    }

    @Test
    public void testRipGame() throws Exception {
        assertThat(ripGame()).isEqualTo(new TorrentTypeCriterion(new TorrentType(GAME_RIP, true)));
    }

    @Test
    public void testConsoleGame() throws Exception {
        assertThat(consoleGame()).isEqualTo(new TorrentTypeCriterion(new TorrentType(GAME_CONSOLE, true)));
    }

    @Test
    public void testEbook() throws Exception {
        assertThat(ebook()).isEqualTo(new TorrentTypeCriterion(new TorrentType(E_BOOK, false)));
    }

    @Test
    public void testEbookEn() throws Exception {
        assertThat(ebookEn()).isEqualTo(new TorrentTypeCriterion(new TorrentType(E_BOOK, true)));
    }

    @Test
    public void testRipProgram() throws Exception {
        assertThat(ripProgram()).isEqualTo(new TorrentTypeCriterion(new TorrentType(PROGRAM_RIP, true)));
    }

    @Test
    public void testIsoProgram() throws Exception {
        assertThat(isoProgram()).isEqualTo(new TorrentTypeCriterion(new TorrentType(PROGRAM_ISO, true)));
    }

    @Test
    public void testMobileProgram() throws Exception {
        assertThat(mobileProgram()).isEqualTo(new TorrentTypeCriterion(new TorrentType(PROGRAM_MOBILE, true)));
    }

    @Test
    public void testSdXxx() throws Exception {
        assertThat(sdXxx()).isEqualTo(new TorrentTypeCriterion(new TorrentType(XXX_SD, true)));
    }

    @Test
    public void testDvdXxx() throws Exception {
        assertThat(dvdXxx()).isEqualTo(new TorrentTypeCriterion(new TorrentType(XXX_DVD, true)));
    }

    @Test
    public void testImageSetXxx() throws Exception {
        assertThat(imageSetXxx()).isEqualTo(new TorrentTypeCriterion(new TorrentType(XXX_IMAGESET, true)));
    }

    @Test
    public void testHdXxx() throws Exception {
        assertThat(hdXxx()).isEqualTo(new TorrentTypeCriterion(new TorrentType(XXX_HD, true)));
    }

}
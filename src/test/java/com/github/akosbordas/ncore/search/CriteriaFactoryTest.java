package com.github.akosbordas.ncore.search;

import com.github.akosbordas.ncore.TorrentType;
import org.junit.Before;
import org.junit.Test;

import static com.github.akosbordas.ncore.TorrentType.*;
import static com.github.akosbordas.ncore.search.CriteriaFactory.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CriteriaFactoryTest {

    private CriteriaFactory criteriaFactory;

    @Before
    public void setUp() throws Exception {
        criteriaFactory = new CriteriaFactory();
    }

    @Test
    public void testSdMovie() throws Exception {
        assertThat(sdMovie()).isEqualTo(new TorrentTypeCriterion(MOVIE_SD));
    }

    @Test
    public void testSdMovieEn() throws Exception {
        TorrentType type = MOVIE_SD;
        type.setEnglish(true);
        assertThat(sdMovie()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testDvdMovie() throws Exception {
        assertThat(dvdMovie()).isEqualTo(new TorrentTypeCriterion(MOVIE_DVD));
    }

    @Test
    public void testDvdMovieEn() throws Exception {
        TorrentType type = MOVIE_DVD;
        type.setEnglish(true);
        assertThat(dvdMovie()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testDvd9Movie() throws Exception {
        assertThat(dvd9Movie()).isEqualTo(new TorrentTypeCriterion(MOVIE_DVD9));
    }

    @Test
    public void testDvd9MovieEn() throws Exception {
        TorrentType type = MOVIE_DVD9;
        type.setEnglish(true);
        assertThat(dvd9Movie()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testHdMovie() throws Exception {
        assertThat(hdMovie()).isEqualTo(new TorrentTypeCriterion(MOVIE_HD));
    }

    @Test
    public void testHdMovieEn() throws Exception {
        TorrentType type = MOVIE_HD;
        type.setEnglish(true);
        assertThat(hdMovie()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testSdSeries() throws Exception {
        assertThat(sdSeries()).isEqualTo(new TorrentTypeCriterion(SERIES_SD));
    }

    @Test
    public void testSdSeriesEn() throws Exception {
        TorrentType type = SERIES_SD;
        type.setEnglish(true);
        assertThat(sdSeries()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testDvdSeries() throws Exception {
        assertThat(dvdSeries()).isEqualTo(new TorrentTypeCriterion(SERIES_DVD));
    }

    @Test
    public void testDvdSeriesEn() throws Exception {
        TorrentType type = SERIES_DVD;
        type.setEnglish(true);
        assertThat(dvdSeries()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testHdSeries() throws Exception {
        assertThat(hdSeries()).isEqualTo(new TorrentTypeCriterion(SERIES_HD));
    }

    @Test
    public void testHdSeriesEn() throws Exception {
        TorrentType type = SERIES_HD;
        type.setEnglish(true);
        assertThat(hdSeriesEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testMp3Music() throws Exception {
        assertThat(mp3Music()).isEqualTo(new TorrentTypeCriterion(MUSIC_MP3));
    }

    @Test
    public void testMp3MusicEn() throws Exception {
        TorrentType type = MUSIC_MP3;
        type.setEnglish(true);
        assertThat(mp3MusicEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testLosslessMusic() throws Exception {
        assertThat(losslessMusic()).isEqualTo(new TorrentTypeCriterion(MUSIC_LOSSLESS));
    }

    @Test
    public void testLosslessMusicEn() throws Exception {
        TorrentType type = MUSIC_LOSSLESS;
        type.setEnglish(true);
        assertThat(losslessMusicEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testMusicClip() throws Exception {
        assertThat(musicClip()).isEqualTo(new TorrentTypeCriterion(MUSIC_CLIP));
    }

    @Test
    public void testMusicClipEn() throws Exception {
        TorrentType type = MUSIC_CLIP;
        type.setEnglish(true);
        assertThat(musicClipEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testIsoGame() throws Exception {
        assertThat(isoGame()).isEqualTo(new TorrentTypeCriterion(GAME_ISO));
    }

    @Test
    public void testIsoGameEn() throws Exception {
        TorrentType type = GAME_ISO;
        type.setEnglish(true);
        assertThat(isoGameEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testRipGame() throws Exception {
        assertThat(ripGame()).isEqualTo(new TorrentTypeCriterion(GAME_RIP));
    }

    @Test
    public void testRipGameEn() throws Exception {
        TorrentType type = GAME_RIP;
        type.setEnglish(true);
        assertThat(ripGameEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testConsoleGame() throws Exception {
        assertThat(consoleGame()).isEqualTo(new TorrentTypeCriterion(GAME_CONSOLE));
    }

    @Test
    public void testConsoleGameEn() throws Exception {
        TorrentType type = GAME_CONSOLE;
        type.setEnglish(true);
        assertThat(consoleGameEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testEbook() throws Exception {
        assertThat(ebook()).isEqualTo(new TorrentTypeCriterion(E_BOOK));
    }

    @Test
    public void testEbookEn() throws Exception {
        TorrentType type = E_BOOK;
        type.setEnglish(true);
        assertThat(ebookEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testRipProgram() throws Exception {
        assertThat(ripProgram()).isEqualTo(new TorrentTypeCriterion(PROGRAM_RIP));
    }

    @Test
    public void testRipProgramEn() throws Exception {
        TorrentType type = PROGRAM_RIP;
        type.setEnglish(true);
        assertThat(ripProgramEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testIsoProgram() throws Exception {
        assertThat(isoProgram()).isEqualTo(new TorrentTypeCriterion(PROGRAM_ISO));
    }

    @Test
    public void testIsoProgramEn() throws Exception {
        TorrentType type = PROGRAM_ISO;
        type.setEnglish(true);
        assertThat(isoProgramEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testMobileProgram() throws Exception {
        assertThat(mobileProgram()).isEqualTo(new TorrentTypeCriterion(PROGRAM_MOBILE));
    }

    @Test
    public void testMobileProgramEn() throws Exception {
        TorrentType type = PROGRAM_MOBILE;
        type.setEnglish(true);
        assertThat(mobileProgramEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testSdXxx() throws Exception {
        assertThat(sdXxx()).isEqualTo(new TorrentTypeCriterion(XXX_SD));
    }

    @Test
    public void testSdXxxEn() throws Exception {
        TorrentType type = XXX_SD;
        type.setEnglish(true);
        assertThat(sdXxxEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testDvdXxx() throws Exception {
        assertThat(dvdXxx()).isEqualTo(new TorrentTypeCriterion(XXX_DVD));
    }

    @Test
    public void testDvdXxxEn() throws Exception {
        TorrentType type = XXX_DVD;
        type.setEnglish(true);
        assertThat(dvdXxxEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testImageSetXxx() throws Exception {
        assertThat(imageSetXxx()).isEqualTo(new TorrentTypeCriterion(XXX_IMAGESET));
    }

    @Test
    public void testImageSetXxxEn() throws Exception {
        TorrentType type = XXX_IMAGESET;
        type.setEnglish(true);
        assertThat(imageSetXxxEn()).isEqualTo(new TorrentTypeCriterion(type));
    }

    @Test
    public void testHdXxx() throws Exception {
        assertThat(hdXxx()).isEqualTo(new TorrentTypeCriterion(XXX_HD));
    }

    @Test
    public void testHdXxxEn() throws Exception {
        TorrentType type = XXX_HD;
        type.setEnglish(true);
        assertThat(hdXxxEn()).isEqualTo(new TorrentTypeCriterion(type));
    }
}
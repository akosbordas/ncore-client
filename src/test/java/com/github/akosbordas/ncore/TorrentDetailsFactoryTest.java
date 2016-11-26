package com.github.akosbordas.ncore;

import com.github.akosbordas.ncore.ebook.EbookTorrentDetails;
import com.github.akosbordas.ncore.game.ConsoleGameTorrentDetails;
import com.github.akosbordas.ncore.game.IsoGameTorrentDetails;
import com.github.akosbordas.ncore.game.RipGameTorrentDetails;
import com.github.akosbordas.ncore.movie.Dvd9MovieTorrentDetails;
import com.github.akosbordas.ncore.movie.DvdMovieTorrentDetails;
import com.github.akosbordas.ncore.movie.HdMovieTorrentDetails;
import com.github.akosbordas.ncore.movie.SdMovieTorrentDetails;
import com.github.akosbordas.ncore.music.ClipMusicTorrentDetails;
import com.github.akosbordas.ncore.music.LosslessMusicTorrentDetails;
import com.github.akosbordas.ncore.music.Mp3MusicTorrentDetails;
import com.github.akosbordas.ncore.program.IsoProgramTorrentDetails;
import com.github.akosbordas.ncore.program.MobileProgramTorrentDetails;
import com.github.akosbordas.ncore.program.RipProgramTorrentDetails;
import com.github.akosbordas.ncore.series.DvdSeriesTorrentDetails;
import com.github.akosbordas.ncore.series.HdSeriesTorrentDetails;
import com.github.akosbordas.ncore.series.SdSeriesTorrentDetails;
import com.github.akosbordas.ncore.xxx.DvdXxxTorrentDetails;
import com.github.akosbordas.ncore.xxx.HdXxxTorrentDetails;
import com.github.akosbordas.ncore.xxx.ImagesetXxxTorrentDetails;
import com.github.akosbordas.ncore.xxx.SdXxxTorrentDetails;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TorrentDetailsFactoryTest extends TestBase {

    private TorrentDetailsFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = TorrentDetailsFactory.getFactoryInstance();
    }

    @Test(expected = TorrentDetailsParseException.class)
    public void shouldFailIfCannotParseTorrentType() throws Exception {
        factory.create("");
    }

    @Test
    public void shouldParseSdMovieTorrentDetails() throws Exception {
        String html = readFile("sd-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(SdMovieTorrentDetails.class);
    }

    @Test
    public void shouldParseDvdMovieTorrentDetails() throws Exception {
        String html = readFile("dvd-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(DvdMovieTorrentDetails.class);
    }

    @Test
    public void shouldParseDvd9MovieTorrentDetails() throws Exception {
        String html = readFile("dvd9-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(Dvd9MovieTorrentDetails.class);
    }

    @Test
    public void shouldParseHdMovieTorrentDetails() throws Exception {
        String html = readFile("hd-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(HdMovieTorrentDetails.class);
    }

    @Test
    public void shouldParseSdSeriesTorrentDetails() throws Exception {
        String html = readFile("sd-series-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(SdSeriesTorrentDetails.class);
    }


    @Test
    public void shouldParseDvdSeriesTorrentDetails() throws Exception {
        String html = readFile("dvd-series-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(DvdSeriesTorrentDetails.class);
    }

    @Test
    public void shouldParseHdSeriesTorrentDetails() throws Exception {
        String html = readFile("hd-series-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(HdSeriesTorrentDetails.class);
    }
    @Test
    public void shouldParseMp3MusicTorrentDetails() throws Exception{
        String html = readFile("mp3-music-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(Mp3MusicTorrentDetails.class);
    }

    @Test
    public void shouldParseLosslessMusicTorrentDetails() throws Exception{
        String html = readFile("lossless-music-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(LosslessMusicTorrentDetails.class);
    }

    @Test
    public void shouldParseClipMusicTorrentDetails() throws Exception{
        String html = readFile("clip-music-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(ClipMusicTorrentDetails.class);
    }

    @Test
    public void shouldParseIsoGameTorrentDetails() throws Exception{
        String html = readFile("iso-game-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(IsoGameTorrentDetails.class);
    }

    @Test
    public void shouldParseRipGameTorrentDetails() throws Exception{
        String html = readFile("rip-game-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(RipGameTorrentDetails.class);
    }

    @Test
    public void shouldParseConsoleGameTorrentDetails() throws Exception{
        String html = readFile("console-game-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(ConsoleGameTorrentDetails.class);
    }

    @Test
    public void shouldParseEbookTorrentDetails() throws Exception{
        String html = readFile("ebook-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(EbookTorrentDetails.class);
    }

    @Test
    public void shouldParseIsoProgramTorrentDetails() throws Exception{
        String html = readFile("iso-program-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(IsoProgramTorrentDetails.class);
    }

    @Test
    public void shouldParseRipProgramTorrentDetails() throws Exception{
        String html = readFile("rip-program-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(RipProgramTorrentDetails.class);
    }

    @Test
    public void shouldParseMobileProgramTorrentDetails() throws Exception{
        String html = readFile("mobile-program-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(MobileProgramTorrentDetails.class);
    }

    @Test
    public void shouldParseSdXxxTorrentDetails() throws Exception{
        String html = readFile("sd-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(SdXxxTorrentDetails.class);
    }

    @Test
    public void shouldParseDvdXxxTorrentDetails() throws Exception{
        String html = readFile("dvd-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(DvdXxxTorrentDetails.class);
    }

    @Test
    public void shouldParseImagesetXxxTorrentDetails() throws Exception{
        String html = readFile("imageset-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(ImagesetXxxTorrentDetails.class);
    }

    @Test
    public void shouldParseHdXxxTorrentDetails() throws Exception{
        String html = readFile("hd-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(HdXxxTorrentDetails.class);
    }

}
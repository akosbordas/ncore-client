package com.github.akosbordas;

import com.github.akosbordas.ebook.EbookTorrentDetails;
import com.github.akosbordas.game.ConsoleGameTorrentDetails;
import com.github.akosbordas.game.IsoGameTorrentDetails;
import com.github.akosbordas.game.RipGameTorrentDetails;
import com.github.akosbordas.movie.Dvd9MovieTorrentDetails;
import com.github.akosbordas.movie.DvdMovieTorrentDetails;
import com.github.akosbordas.movie.HdMovieTorrentDetails;
import com.github.akosbordas.movie.SdMovieTorrentDetails;
import com.github.akosbordas.music.ClipMusicTorrentDetails;
import com.github.akosbordas.music.LosslessMusicTorrentDetails;
import com.github.akosbordas.music.Mp3MusicTorrentDetails;
import com.github.akosbordas.program.IsoProgramTorrentDetails;
import com.github.akosbordas.program.MobileProgramTorrentDetails;
import com.github.akosbordas.program.RipProgramTorrentDetails;
import com.github.akosbordas.series.DvdSeriesTorrentDetails;
import com.github.akosbordas.series.HdSeriesTorrentDetails;
import com.github.akosbordas.series.SdSeriesTorrentDetails;
import com.github.akosbordas.xxx.DvdXxxTorrentDetails;
import com.github.akosbordas.xxx.HdXxxTorrentDetails;
import com.github.akosbordas.xxx.ImagesetXxxTorrentDetails;
import com.github.akosbordas.xxx.SdXxxTorrentDetails;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


public class TorrentDetailsFactoryTest {

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
        String html = readHtml("sd-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(SdMovieTorrentDetails.class);
    }

    @Test
    public void shouldParseDvdMovieTorrentDetails() throws Exception {
        String html = readHtml("dvd-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(DvdMovieTorrentDetails.class);
    }

    @Test
    public void shouldParseDvd9MovieTorrentDetails() throws Exception {
        String html = readHtml("dvd9-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(Dvd9MovieTorrentDetails.class);
    }

    @Test
    public void shouldParseHdMovieTorrentDetails() throws Exception {
        String html = readHtml("hd-movie-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(HdMovieTorrentDetails.class);
    }

    @Test
    public void shouldParseSdSeriesTorrentDetails() throws Exception {
        String html = readHtml("sd-series-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(SdSeriesTorrentDetails.class);
    }


    @Test
    public void shouldParseDvdSeriesTorrentDetails() throws Exception {
        String html = readHtml("dvd-series-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(DvdSeriesTorrentDetails.class);
    }

    @Test
    public void shouldParseHdSeriesTorrentDetails() throws Exception {
        String html = readHtml("hd-series-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(HdSeriesTorrentDetails.class);
    }
    @Test
    public void shouldParseMp3MusicTorrentDetails() throws Exception{
        String html = readHtml("mp3-music-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(Mp3MusicTorrentDetails.class);
    }

    @Test
    public void shouldParseLosslessMusicTorrentDetails() throws Exception{
        String html = readHtml("lossless-music-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(LosslessMusicTorrentDetails.class);
    }

    @Test
    public void shouldParseClipMusicTorrentDetails() throws Exception{
        String html = readHtml("clip-music-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(ClipMusicTorrentDetails.class);
    }

    @Test
    public void shouldParseIsoGameTorrentDetails() throws Exception{
        String html = readHtml("iso-game-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(IsoGameTorrentDetails.class);
    }

    @Test
    public void shouldParseRipGameTorrentDetails() throws Exception{
        String html = readHtml("rip-game-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(RipGameTorrentDetails.class);
    }

    @Test
    public void shouldParseConsoleGameTorrentDetails() throws Exception{
        String html = readHtml("console-game-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(ConsoleGameTorrentDetails.class);
    }

    @Test
    public void shouldParseEbookTorrentDetails() throws Exception{
        String html = readHtml("ebook-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(EbookTorrentDetails.class);
    }

    @Test
    public void shouldParseIsoProgramTorrentDetails() throws Exception{
        String html = readHtml("iso-program-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(IsoProgramTorrentDetails.class);
    }

    @Test
    public void shouldParseRipProgramTorrentDetails() throws Exception{
        String html = readHtml("rip-program-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(RipProgramTorrentDetails.class);
    }

    @Test
    public void shouldParseMobileProgramTorrentDetails() throws Exception{
        String html = readHtml("mobile-program-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(MobileProgramTorrentDetails.class);
    }

    @Test
    public void shouldParseSdXxxTorrentDetails() throws Exception{
        String html = readHtml("sd-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(SdXxxTorrentDetails.class);
    }

    @Test
    public void shouldParseDvdXxxTorrentDetails() throws Exception{
        String html = readHtml("dvd-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(DvdXxxTorrentDetails.class);
    }

    @Test
    public void shouldParseImagesetXxxTorrentDetails() throws Exception{
        String html = readHtml("imageset-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(ImagesetXxxTorrentDetails.class);
    }

    @Test
    public void shouldParseHdXxxTorrentDetails() throws Exception{
        String html = readHtml("hd-xxx-torrent-details.html");
        TorrentDetails torrentDetails = factory.create(html);
        assertThat(torrentDetails).isInstanceOf(HdXxxTorrentDetails.class);
    }

    private String readHtml(String name) throws IOException {
        return IOUtils.toString(
                this.getClass().getResourceAsStream(name),
                "UTF-8"
        );

    }
}
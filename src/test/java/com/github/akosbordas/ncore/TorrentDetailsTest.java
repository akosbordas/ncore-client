package com.github.akosbordas.ncore;

import com.github.akosbordas.ncore.ebook.EbookTorrentDetails;
import com.github.akosbordas.ncore.game.ConsoleGameTorrentDetails;
import com.github.akosbordas.ncore.game.GameTorrentDetails;
import com.github.akosbordas.ncore.game.IsoGameTorrentDetails;
import com.github.akosbordas.ncore.game.RipGameTorrentDetails;
import com.github.akosbordas.ncore.movie.*;
import com.github.akosbordas.ncore.music.ClipMusicTorrentDetails;
import com.github.akosbordas.ncore.music.LosslessMusicTorrentDetails;
import com.github.akosbordas.ncore.music.Mp3MusicTorrentDetails;
import com.github.akosbordas.ncore.music.MusicTorrentDetails;
import com.github.akosbordas.ncore.program.MobileProgramTorrentDetails;
import com.github.akosbordas.ncore.program.ProgramTorrentDetails;
import com.github.akosbordas.ncore.series.DvdSeriesTorrentDetails;
import com.github.akosbordas.ncore.series.HdSeriesTorrentDetails;
import com.github.akosbordas.ncore.series.SdSeriesTorrentDetails;
import com.github.akosbordas.ncore.series.SeriesTorrentDetails;
import com.github.akosbordas.ncore.xxx.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.github.akosbordas.ncore.TorrentDetails.DATE_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TorrentDetailsTest extends TestBase {

    private TorrentDetails torrentDetails;

    @Before
    public void setUp() {
        torrentDetails = new DefaultTorrentDetails();
    }

    @Test
    public void shouldPassIfParsedAllFields() throws Exception {
        String html = readHtml("torrent-details-parse-success.html");
        torrentDetails.parse(html);
        assertThat(torrentDetails.getUploadDate()).isEqualTo(DATE_FORMAT.parse("2016-07-25 20:00:29"));
        assertThat(torrentDetails.getUploader()).isEqualTo("Anonymous");
        assertThat(torrentDetails.getCommentCount()).isEqualTo("2 db");
        assertThat(torrentDetails.getSeederCount()).isEqualTo("66");
        assertThat(torrentDetails.getLeecherCount()).isEqualTo("0");
        assertThat(torrentDetails.getDownloadCount()).isEqualTo("++");
        assertThat(torrentDetails.getSpeed()).isEqualTo("387.98 KB/s (becsült)");
        assertThat(torrentDetails.getSize()).isEqualTo("965.06 MB (1011940950 bájt)");
        assertThat(torrentDetails.getFileCount()).isEqualTo("2");
        assertThat(torrentDetails.getDescription()).isEqualTo("Eredeti release! Inception.2010.iNTERNAL.BDRip.x264-REGRET Két ifjú és ambiciózus építész együtt dolgozik, s nem csak kollégák, hanem a legjobb barátok is, ám kapcsolatukra némi árnyék vetül. A vállalatnál kifejlesztettek egy olyan technológiát, amely segítségével be lehet lépni az álmokba, és bizonyos emberek fejéből így információhoz lehet jutni. Amikor Cobb él ezzel a lehetőséggel, a dolgok egyre bonyolultabbakká válnak... Eredet (Inception) - Magyar Szinkronos Előzetes https://www.youtube.com/watch?v=Ypu8DP2ci-M");

    }

    @Test
    public void shouldPassIfParsedEmptyStringFromClassWithoutValue() throws IOException {
        String html = readHtml("torrent-details-parse-empty-string.html");
        torrentDetails.parse(html);
        assertThat(torrentDetails.getCommentCount()).isEqualTo("");

    }

    @Test(expected = TorrentDetailsParseException.class)
    public void shouldPassIfThrowsExceptionOnParse() throws IOException {
        String html = readHtml("torrent-details-parse-throw-exception.html");
        torrentDetails.parse(html);

    }

    @Test
    public void shouldPassIfParsedLanguageCorrectly() throws IOException {
        String html = readHtml("torrent-details-language-parse.html");
        assertTrue(torrentDetails.parseType(html).isEnglish());

    }

    @Test(expected = TorrentDetailsParseException.class)
    public void shouldPassIfThrowsExceptionOnTypeParse() throws IOException {
        String html = readHtml("torrent-details-parse-type-throw-exception.html");
        torrentDetails.parseType(html);

    }

    @Test
    public void shouldParseSdMovieTorrentType() throws IOException {
        String html = readHtml("sd-movie-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.MOVIE_SD);
    }

    @Test
    public void shouldParseHdMovieTorrentType() throws IOException {
        String html = readHtml("hd-movie-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.MOVIE_HD);
    }

    @Test
    public void shouldParseDvdMovieTorrentType() throws IOException {
        String html = readHtml("dvd-movie-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.MOVIE_DVD);
    }

    @Test
    public void shouldParseDvd9MovieTorrentType() throws IOException {
        String html = readHtml("dvd9-movie-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.MOVIE_DVD9);
    }

    @Test
    public void shouldParseSdSeriesTorrentType() throws IOException {
        String html = readHtml("sd-series-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.SERIES_SD);
    }

    @Test
    public void shouldParseHdSeriesTorrentType() throws IOException {
        String html = readHtml("hd-series-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.SERIES_HD);
    }

    @Test
    public void shouldParseDvdSeriesTorrentType() throws IOException {
        String html = readHtml("dvd-series-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.SERIES_DVD);
    }

    @Test
    public void shouldParseMp3MusicTorrentType() throws IOException {
        String html = readHtml("mp3-music-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.MUSIC_MP3);
    }

    @Test
    public void shouldParseLosslessMusicTorrentType() throws IOException {
        String html = readHtml("lossless-music-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.MUSIC_LOSSLESS);
    }

    @Test
    public void shouldParseClipMusicTorrentType() throws IOException {
        String html = readHtml("clip-music-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.MUSIC_CLIP);
    }

    @Test
    public void shouldParseEbookTorrentType() throws IOException {
        String html = readHtml("ebook-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.E_BOOK);
    }

    @Test
    public void shouldParseIsoGameTorrentType() throws IOException {
        String html = readHtml("iso-game-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.GAME_ISO);
    }

    @Test
    public void shouldParseRipGameTorrentType() throws IOException {
        String html = readHtml("rip-game-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.GAME_RIP);
    }

    @Test
    public void shouldParseConsoleGameTorrentType() throws IOException {
        String html = readHtml("console-game-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.GAME_CONSOLE);
    }

    @Test
    public void shouldParseSdXxxTorrentType() throws IOException {
        String html = readHtml("sd-xxx-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.XXX_SD);
    }

    @Test
    public void shouldParseHdXxxTorrentType() throws IOException {
        String html = readHtml("hd-xxx-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.XXX_HD);
    }

    @Test
    public void shouldParseDvdXxxTorrentType() throws IOException {
        String html = readHtml("dvd-xxx-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.XXX_DVD);
    }

    @Test
    public void shouldParseImagesetXxxTorrentType() throws IOException {
        String html = readHtml("imageset-xxx-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.XXX_IMAGESET);
    }

    @Test
    public void shouldParseIsoProgramTorrentType() throws IOException {
        String html = readHtml("iso-program-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.PROGRAM_ISO);
    }

    @Test
    public void shouldParseRipProgramTorrentType() throws IOException {
        String html = readHtml("rip-program-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.PROGRAM_RIP);
    }

    @Test
    public void shouldParseMobileProgramTorrentType() throws IOException {
        String html = readHtml("mobile-program-torrent-type.html");
        assertThat(torrentDetails.parseType(html)).isSameAs(TorrentType.PROGRAM_MOBILE);
    }

    @Test
    public void shouldParseMovieCustomTorrentDetails() throws IOException {
        MovieTorrentDetails movieTorrentDetails = new MovieTorrentDetails();
        movieTorrentDetails.customParse(TorrentDetails.parseHtml(readHtml("movie-custom-torrent-details.html")));
        assertThat(movieTorrentDetails.getInfoBarTitle()).isEqualTo("Moby Dick");
        assertThat(movieTorrentDetails.getReleaseDate()).isEqualTo("1998");
        assertThat(movieTorrentDetails.getDirector()).isEqualTo("Franc Roddam");
        assertThat(movieTorrentDetails.getActors()).isEqualTo("Henry Thomas, Bruce Spence, Hugh Keays-Byrne, Robin Cuming, Shane Connor");
        assertThat(movieTorrentDetails.getCountry()).isEqualTo("UK, Ausztrália, USA");
        assertThat(movieTorrentDetails.getLength()).isEqualTo("180 perc");
        assertThat(movieTorrentDetails.getTags()).isEqualTo("kaland, dráma, thriller");
        assertThat(movieTorrentDetails.getImdbRating()).isEqualTo("6.5");
        assertThat(movieTorrentDetails.getImdbURL()).isEqualTo("http://hungarian.imdb.com/title/tt0120756");
        assertThat(movieTorrentDetails.getMafabURL()).isEqualTo("http://www.mafab.hu/movies/mob...");
        assertThat(movieTorrentDetails.toString()).isEqualTo("MovieTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='Moby Dick', releaseDate='1998', director='Franc Roddam', actors='Henry Thomas, Bruce Spence, Hugh Keays-Byrne, Robin Cuming, Shane Connor', country='UK, Ausztrália, USA', length='180 perc', tags='kaland, dráma, thriller', imdbRating='6.5', imdbURL='http://hungarian.imdb.com/title/tt0120756', otherURL='', mafabURL='http://www.mafab.hu/movies/mob...'}");
    }

    //Did not override custom parse: SeriesTorrentDetails,GameTorrentDetails,ProgramTorrentDetails,XxxTorrentDetails

    @Test
    public void shouldParseMusicCustomTorrentDetails() throws IOException {
        MusicTorrentDetails musicTorrentDetails = new MusicTorrentDetails();
        musicTorrentDetails.customParse(TorrentDetails.parseHtml(readHtml("music-custom-torrent-details.html")));
        assertThat(musicTorrentDetails.getTags()).isEqualTo("audiobook");
        assertThat(musicTorrentDetails.toString()).isEqualTo("MusicTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', tags='audiobook'}");
    }

    @Test
    public void shouldParseEbookCustomTorrentDetails() throws IOException {
        EbookTorrentDetails ebookTorrentDetails = new EbookTorrentDetails();
        ebookTorrentDetails.customParse(TorrentDetails.parseHtml(readHtml("ebook-custom-torrent-details.html")));
        assertThat(ebookTorrentDetails.getTags()).isEqualTo("sport");
        assertThat(ebookTorrentDetails.toString()).isEqualTo("EbookTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', tags='sport'}");
    }

    @Test
    public void toStringShouldContainsAllBasicInfo() throws Exception {
        assertThat(new EbookTorrentDetails().toString()).isEqualTo("EbookTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', tags='null'}");
        assertThat(new ConsoleGameTorrentDetails().toString()).isEqualTo("ConsoleGameTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new GameTorrentDetails().toString()).isEqualTo("GameTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new IsoGameTorrentDetails().toString()).isEqualTo("IsoGameTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new RipGameTorrentDetails().toString()).isEqualTo("RipGameTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new Dvd9MovieTorrentDetails().toString()).isEqualTo("Dvd9MovieTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new DvdMovieTorrentDetails().toString()).isEqualTo("DvdMovieTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new HdMovieTorrentDetails().toString()).isEqualTo("HdMovieTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new MovieTorrentDetails().toString()).isEqualTo("MovieTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new SdMovieTorrentDetails().toString()).isEqualTo("SdMovieTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new ClipMusicTorrentDetails().toString()).isEqualTo("ClipMusicTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', tags='null'}");
        assertThat(new LosslessMusicTorrentDetails().toString()).isEqualTo("LosslessMusicTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', tags='null'}");
        assertThat(new Mp3MusicTorrentDetails().toString()).isEqualTo("Mp3MusicTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', tags='null'}");
        assertThat(new MusicTorrentDetails().toString()).isEqualTo("MusicTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', tags='null'}");
        assertThat(new IsoGameTorrentDetails().toString()).isEqualTo("IsoGameTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new MobileProgramTorrentDetails().toString()).isEqualTo("MobileProgramTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new ProgramTorrentDetails().toString()).isEqualTo("ProgramTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new RipGameTorrentDetails().toString()).isEqualTo("RipGameTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new DvdSeriesTorrentDetails().toString()).isEqualTo("DvdSeriesTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new HdSeriesTorrentDetails().toString()).isEqualTo("HdSeriesTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new SdSeriesTorrentDetails().toString()).isEqualTo("SdSeriesTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new SeriesTorrentDetails().toString()).isEqualTo("SeriesTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null', infoBarTitle='null', releaseDate='null', director='null', actors='null', country='null', length='null', tags='null', imdbRating='null', imdbURL='null', otherURL='null', mafabURL='null'}");
        assertThat(new DvdXxxTorrentDetails().toString()).isEqualTo("DvdXxxTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new HdXxxTorrentDetails().toString()).isEqualTo("HdXxxTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new ImagesetXxxTorrentDetails().toString()).isEqualTo("ImagesetXxxTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new SdXxxTorrentDetails().toString()).isEqualTo("SdXxxTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");
        assertThat(new XxxTorrentDetails().toString()).isEqualTo("XxxTorrentDetails{uploadDate='null', uploader='null', commentCount='null', seederCount='null', leecherCount='null', downloadCount='null', speed='null', size='null', fileCount='null', description='null'}");

    }
}
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

import static com.github.akosbordas.TorrentDetails.parseType;

public class TorrentDetailsFactory {

    private static final TorrentDetailsFactory factoryInstance = new TorrentDetailsFactory();

    private TorrentDetailsFactory() {
    }

    public static TorrentDetailsFactory getFactoryInstance() {
        return factoryInstance;
    }

    public TorrentDetails create(String document) {

        TorrentType type = parseType(document);

        switch (type) {
            case MOVIE_SD:
                return new SdMovieTorrentDetails().parse(document);
            case MOVIE_HD:
                return new HdMovieTorrentDetails().parse(document);
            case MOVIE_DVD:
                return new DvdMovieTorrentDetails().parse(document);
            case MOVIE_DVD9:
                return new Dvd9MovieTorrentDetails().parse(document);
            case SERIES_SD:
                return new SdSeriesTorrentDetails().parse(document);
            case SERIES_HD:
                return new HdSeriesTorrentDetails().parse(document);
            case SERIES_DVD:
                return new DvdSeriesTorrentDetails().parse(document);
            case MUSIC_MP3:
                return new Mp3MusicTorrentDetails().parse(document);
            case MUSIC_LOSSLESS:
                return new LosslessMusicTorrentDetails().parse(document);
            case MUSIC_CLIP:
                return new ClipMusicTorrentDetails().parse(document);
            case GAME_ISO:
                return new IsoGameTorrentDetails().parse(document);
            case GAME_RIP:
                return new RipGameTorrentDetails().parse(document);
            case GAME_CONSOLE:
                return new ConsoleGameTorrentDetails().parse(document);
            case E_BOOK:
                return new EbookTorrentDetails().parse(document);
            case PROGRAM_ISO:
                return new IsoProgramTorrentDetails().parse(document);
            case PROGRAM_RIP:
                return new RipProgramTorrentDetails().parse(document);
            case PROGRAM_MOBILE:
                return new MobileProgramTorrentDetails().parse(document);
            case XXX_SD:
                return new SdXxxTorrentDetails().parse(document);
            case XXX_DVD:
                return new DvdXxxTorrentDetails().parse(document);
            case XXX_IMAGESET:
                return new ImagesetXxxTorrentDetails().parse(document);
            case XXX_HD:
                return new HdXxxTorrentDetails().parse(document);
            default:
                return new DefaultTorrentDetails().parse(document);

        }


    }


}

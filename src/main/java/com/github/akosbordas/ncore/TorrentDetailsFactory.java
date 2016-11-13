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

import static com.github.akosbordas.ncore.TorrentDetails.parseType;

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

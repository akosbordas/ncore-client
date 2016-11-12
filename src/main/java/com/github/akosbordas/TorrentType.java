package com.github.akosbordas;

public enum TorrentType {
    MOVIE_SD {
        @Override
        public String getSearchValue() {
            return "xvid";
        }
    },
    MOVIE_DVD {
        @Override
        public String getSearchValue() {
            return "dvd";
        }
    },
    MOVIE_DVD9 {
        @Override
        public String getSearchValue() {
            return "dvd9";
        }
    },
    MOVIE_HD {
        @Override
        public String getSearchValue() {
            return "hd";
        }
    },
    SERIES_SD {
        @Override
        public String getSearchValue() {
            return "xvidser";
        }
    },
    SERIES_DVD {
        @Override
        public String getSearchValue() {
            return "dvdser";
        }
    },
    SERIES_HD {
        @Override
        public String getSearchValue() {
            return "hdser";
        }
    },
    MUSIC_MP3 {
        @Override
        public String getSearchValue() {
            return "mp3";
        }
    },
    MUSIC_LOSSLESS {
        @Override
        public String getSearchValue() {
            return "lossless";
        }
    },
    MUSIC_CLIP {
        @Override
        public String getSearchValue() {
            return "clip";
        }
    },
    GAME_ISO {
        @Override
        public String getSearchValue() {
            return "game_iso";
        }
    },
    GAME_RIP {
        @Override
        public String getSearchValue() {
            return "game_rip";
        }
    },
    GAME_CONSOLE {
        @Override
        public String getSearchValue() {
            return "console";
        }
    },
    E_BOOK {
        @Override
        public String getSearchValue() {
            return "ebook";
        }
    },
    PROGRAM_RIP {
        @Override
        public String getSearchValue() {
            return "misc";
        }
    },
    PROGRAM_ISO {
        @Override
        public String getSearchValue() {
            return "iso";
        }
    },
    PROGRAM_MOBILE {
        @Override
        public String getSearchValue() {
            return "mobil";
        }
    },
    XXX_SD {
        @Override
        public String getSearchValue() {
            return "xxx_xvid";
        }
    },
    XXX_DVD {
        @Override
        public String getSearchValue() {
            return "xxx_dvd";
        }
    },
    XXX_IMAGESET {
        @Override
        public String getSearchValue() {
            return "xxx_imageset";
        }
    },
    XXX_HD {
        @Override
        public String getSearchValue() {
            return "xxx_hd";
        }
    };

    private boolean english;

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }

    public String getSearchKeyForType() {
        return "tipus";
    }

    public abstract String getSearchValue();
}

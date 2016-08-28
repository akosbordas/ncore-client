package com.github.akosbordas;

public class TorrentDetailsParseException extends RuntimeException {

    public TorrentDetailsParseException() {
    }

    public TorrentDetailsParseException(String message) {
        super(message);
    }

    public TorrentDetailsParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public TorrentDetailsParseException(Throwable cause) {
        super("Couldn't parse torrent details",cause);
    }

    public TorrentDetailsParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



}

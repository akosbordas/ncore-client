package com.github.akosbordas.ncore;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public abstract class TorrentDetails {

    protected Date uploadDate;
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    {
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("Europe/Budapest"));
    }

    protected String uploader;
    protected String commentCount;
    protected String seederCount;
    protected String leecherCount;
    protected String downloadCount;
    protected String speed;
    protected String size;
    protected String fileCount;
    protected String description;
    protected TorrentType torrentType;

    public static Document parseHtml(String html){
        return Jsoup.parse(html,"https://ncore.cc/");
    }

    public TorrentDetails parse(String html, TorrentType type) {

        Document document = parseHtml(html);

        try {
            uploadDate = DATE_FORMAT.parse(extractGenericInfoColumn(1, 4, document));
            uploader = extractGenericInfoColumn(1, 6, document);
            commentCount = extractGenericInfoColumn(1, 8, document);

            seederCount = extractGenericInfoColumn(2, 2, document);
            leecherCount = extractGenericInfoColumn(2, 4, document);
            downloadCount = extractGenericInfoColumn(2, 6, document);
            speed = extractGenericInfoColumn(2, 8, document);
            size = extractGenericInfoColumn(2, 10, document);
            fileCount = extractGenericInfoColumn(2, 14, document);
            description = document.select("div.torrent_leiras.proba42").text();

            customParse(document);

        } catch (Exception e) {
            throw new TorrentDetailsParseException(e);
        }

        this.torrentType = type;

        return this;
    }

    protected static String extractGenericInfoColumn(int column, int child, Document document) {
        return document.select("div.torrent_reszletek > div.torrent_col" + column + " div:nth-child(" + child + ")").text();
    }

    protected static String extractTypeSpecificInfoByName(Document document, String details) {
        return document.select("div.torrent_leiras td:contains(" + details + "):first-child~td").text();
    }

    public abstract void customParse(Document document);

    public static TorrentType parseType(String html) {
        Document document = parseHtml(html);

        String typeString = document.select("div.torrent_reszletek > div.torrent_col1 div:nth-child(2)").text();

        TorrentType type;

        if (typeString.contains("Film") && typeString.contains("SD")) {
            type = new TorrentType(TorrentType.MOVIE_SD);
        } else if (typeString.contains("Film") && typeString.contains("DVD9")) {
            type = new TorrentType(TorrentType.MOVIE_DVD9);
        } else if (typeString.contains("Film") && typeString.contains("DVD")) {
            type = new TorrentType(TorrentType.MOVIE_DVD);
        }  else if (typeString.contains("Film") && typeString.contains("HD")) {
            type = new TorrentType(TorrentType.MOVIE_HD);
        } else if (typeString.contains("Sorozat") && typeString.contains("SD")) {
            type = new TorrentType(TorrentType.SERIES_SD);
        } else if (typeString.contains("Sorozat") && typeString.contains("HD")) {
            type = new TorrentType(TorrentType.SERIES_HD);
        } else if (typeString.contains("Sorozat") && typeString.contains("DVDR")) {
            type = new TorrentType(TorrentType.SERIES_DVD);
        } else if (typeString.contains("Zene") && typeString.contains("MP3")) {
            type = new TorrentType(TorrentType.MUSIC_MP3);
        } else if (typeString.contains("Zene") && typeString.contains("Lossless")) {
            type = new TorrentType(TorrentType.MUSIC_LOSSLESS);
        } else if (typeString.contains("Zene") && typeString.contains("Klip")) {
            type = new TorrentType(TorrentType.MUSIC_CLIP);
        } else if (typeString.contains("Játék") && typeString.contains("ISO")) {
            type = new TorrentType(TorrentType.GAME_ISO);
        } else if (typeString.contains("Játék") && typeString.contains("RIP")) {
            type = new TorrentType(TorrentType.GAME_RIP);
        } else if (typeString.contains("Játék") && typeString.contains("Konzol")) {
            type = new TorrentType(TorrentType.GAME_CONSOLE);
        } else if (typeString.contains("Ebook")) {
            type = new TorrentType(TorrentType.E_BOOK);
        } else if (typeString.contains("Program") && typeString.contains("ISO")) {
            type = new TorrentType(TorrentType.PROGRAM_ISO);
        } else if (typeString.contains("Program") && typeString.contains("RIP")) {
            type = new TorrentType(TorrentType.PROGRAM_RIP);
        } else if (typeString.contains("Program") && typeString.contains("Mobil")) {
            type = new TorrentType(TorrentType.PROGRAM_MOBILE);
        } else if (typeString.contains("XXX") && typeString.contains("SD")) {
            type = new TorrentType(TorrentType.XXX_SD);
        } else if (typeString.contains("XXX") && typeString.contains("HD")) {
            type = new TorrentType(TorrentType.XXX_HD);
        } else if (typeString.contains("XXX") && typeString.contains("DVD")) {
            type = new TorrentType(TorrentType.XXX_DVD);
        } else if (typeString.contains("XXX") && typeString.contains("Imageset")) {
            type = new TorrentType(TorrentType.XXX_IMAGESET);
        } else {
            throw new TorrentDetailsParseException("Couldn't parse torrent type from: " + html);
        }

        type.setEnglish(typeString.endsWith("/EN"));

        return type;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public String getUploader() {
        return uploader;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public String getSeederCount() {
        return seederCount;
    }

    public String getLeecherCount() {
        return leecherCount;
    }

    public String getDownloadCount() {
        return downloadCount;
    }

    public String getSpeed() {
        return speed;
    }

    public String getSize() {
        return size;
    }

    public String getFileCount() {
        return fileCount;
    }

    public String getDescription() {
        return description;
    }

    public TorrentType getTorrentType() {
        return torrentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TorrentDetails details = (TorrentDetails) o;
        return Objects.equals(uploadDate, details.uploadDate) &&
                Objects.equals(uploader, details.uploader) &&
                Objects.equals(commentCount, details.commentCount) &&
                Objects.equals(seederCount, details.seederCount) &&
                Objects.equals(leecherCount, details.leecherCount) &&
                Objects.equals(downloadCount, details.downloadCount) &&
                Objects.equals(speed, details.speed) &&
                Objects.equals(size, details.size) &&
                Objects.equals(fileCount, details.fileCount) &&
                Objects.equals(description, details.description) &&
                Objects.equals(torrentType, details.torrentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uploadDate, uploader, commentCount, seederCount, leecherCount, downloadCount, speed, size, fileCount, description, torrentType);
    }
}

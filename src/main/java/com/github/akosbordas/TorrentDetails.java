package com.github.akosbordas;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TorrentDetails {

    private Date uploadDate;
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String uploader;
    private String commentCount;
    private String seederCount;
    private String leecherCount;
    private String downloadCount;
    private String speed;
    private String size;
    private String fileCount;
    private String description;

    public static Document parseHtml(String html){
        return Jsoup.parse(html,"https://ncore.cc/");
    }

    public TorrentDetails parse(String html) {

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

        boolean isEnglish = typeString.contains("EN");
        TorrentType type;


        if (typeString.contains("Film") && typeString.contains("SD")) {
            type = TorrentType.MOVIE_SD;
        } else if (typeString.contains("Film") && typeString.contains("DVD9")) {
            type = TorrentType.MOVIE_DVD9;
        } else if (typeString.contains("Film") && typeString.contains("DVD")) {
            type = TorrentType.MOVIE_DVD;
        }  else if (typeString.contains("Film") && typeString.contains("HD")) {
            type = TorrentType.MOVIE_HD;
        } else if (typeString.contains("Sorozat") && typeString.contains("SD")) {
            type = TorrentType.SERIES_SD;
        } else if (typeString.contains("Sorozat") && typeString.contains("HD")) {
            type = TorrentType.SERIES_HD;
        } else if (typeString.contains("Sorozat") && typeString.contains("DVDR")) {
            type = TorrentType.SERIES_DVD;
        } else if (typeString.contains("Zene") && typeString.contains("MP3")) {
            type = TorrentType.MUSIC_MP3;
        } else if (typeString.contains("Zene") && typeString.contains("Lossless")) {
            type = TorrentType.MUSIC_LOSSLESS;
        } else if (typeString.contains("Zene") && typeString.contains("Klip")) {
            type = TorrentType.MUSIC_CLIP;
        } else if (typeString.contains("Játék") && typeString.contains("ISO")) {
            type = TorrentType.GAME_ISO;
        } else if (typeString.contains("Játék") && typeString.contains("RIP")) {
            type = TorrentType.GAME_RIP;
        } else if (typeString.contains("Játék") && typeString.contains("Konzol")) {
            type = TorrentType.GAME_CONSOLE;
        } else if (typeString.contains("Ebook")) {
            type = TorrentType.E_BOOK;
        } else if (typeString.contains("Program") && typeString.contains("ISO")) {
            type = TorrentType.PROGRAM_ISO;
        } else if (typeString.contains("Program") && typeString.contains("RIP")) {
            type = TorrentType.PROGRAM_RIP;
        } else if (typeString.contains("Program") && typeString.contains("Mobil")) {
            type = TorrentType.PROGRAM_MOBILE;
        } else if (typeString.contains("XXX") && typeString.contains("SD")) {
            type = TorrentType.XXX_SD;
        } else if (typeString.contains("XXX") && typeString.contains("HD")) {
            type = TorrentType.XXX_HD;
        } else if (typeString.contains("XXX") && typeString.contains("DVD")) {
            type = TorrentType.XXX_DVD;
        } else if (typeString.contains("XXX") && typeString.contains("Imageset")) {
            type = TorrentType.XXX_IMAGESET;
        } else {
            throw new TorrentDetailsParseException("Couldn't parse torrent type");
        }

        type.setEnglish(isEnglish);
        return type;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getSeederCount() {
        return seederCount;
    }

    public void setSeederCount(String seederCount) {
        this.seederCount = seederCount;
    }

    public String getLeecherCount() {
        return leecherCount;
    }

    public void setLeecherCount(String leecherCount) {
        this.leecherCount = leecherCount;
    }

    public String getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(String downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileCount() {
        return fileCount;
    }

    public void setFileCount(String fileCount) {
        this.fileCount = fileCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TorrentDetails that = (TorrentDetails) o;

        if (uploadDate != null ? !uploadDate.equals(that.uploadDate) : that.uploadDate != null) return false;
        if (uploader != null ? !uploader.equals(that.uploader) : that.uploader != null) return false;
        if (commentCount != null ? !commentCount.equals(that.commentCount) : that.commentCount != null) return false;
        if (seederCount != null ? !seederCount.equals(that.seederCount) : that.seederCount != null) return false;
        if (leecherCount != null ? !leecherCount.equals(that.leecherCount) : that.leecherCount != null) return false;
        if (downloadCount != null ? !downloadCount.equals(that.downloadCount) : that.downloadCount != null)
            return false;
        if (speed != null ? !speed.equals(that.speed) : that.speed != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (fileCount != null ? !fileCount.equals(that.fileCount) : that.fileCount != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        int result = uploadDate != null ? uploadDate.hashCode() : 0;
        result = 31 * result + (uploader != null ? uploader.hashCode() : 0);
        result = 31 * result + (commentCount != null ? commentCount.hashCode() : 0);
        result = 31 * result + (seederCount != null ? seederCount.hashCode() : 0);
        result = 31 * result + (leecherCount != null ? leecherCount.hashCode() : 0);
        result = 31 * result + (downloadCount != null ? downloadCount.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (fileCount != null ? fileCount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    //NOT GENERATED
    public String toString() {
        return  "uploadDate=" + uploadDate +
                ", uploader='" + uploader + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", seederCount='" + seederCount + '\'' +
                ", leecherCount='" + leecherCount + '\'' +
                ", downloadCount='" + downloadCount + '\'' +
                ", speed='" + speed + '\'' +
                ", size='" + size + '\'' +
                ", fileCount='" + fileCount + '\'' +
                ", description='" + description + '\'';
    }
}

package com.github.akosbordas.ncore.movie;

import com.github.akosbordas.ncore.TorrentDetails;
import org.jsoup.nodes.Document;

public class MovieTorrentDetails extends TorrentDetails {

    protected String infoBarTitle;
    protected String releaseDate;
    protected String director;
    protected String actors;
    protected String country;
    protected String length;
    protected String tags;
    protected String imdbRating;
    protected String imdbURL;
    protected String otherURL;
    protected String mafabURL;


    public String getInfoBarTitle() {
        return infoBarTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public String getActors() {
        return actors;
    }

    public String getCountry() {
        return country;
    }

    public String getLength() {
        return length;
    }

    public String getTags() {
        return tags;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbURL() {
        return imdbURL;
    }

    public String getOtherURL() {
        return otherURL;
    }

    public String getMafabURL() {
        return mafabURL;
    }

    public void customParse(Document document) {

        infoBarTitle = document.select("div.infobar_title").text();
        releaseDate = extractTypeSpecificInfoByName(document, "Megjelenés éve");
        director = extractTypeSpecificInfoByName(document, "Rendező");
        actors = extractTypeSpecificInfoByName(document, "Szereplők");
        country = extractTypeSpecificInfoByName(document, "Ország");
        length = extractTypeSpecificInfoByName(document, "Hossz");
        tags = extractTypeSpecificInfoByName(document, "Címkék");
        imdbRating = extractTypeSpecificInfoByName(document, "IMDb értékelés");
        imdbURL = extractTypeSpecificInfoByName(document, "IMDb link");
        otherURL = extractTypeSpecificInfoByName(document, "Egyéb link");
        mafabURL = extractTypeSpecificInfoByName(document, "Mafab.hu link");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MovieTorrentDetails{");
        sb.append("uploadDate='").append(uploadDate).append('\'');
        sb.append(", uploader='").append(uploader).append('\'');
        sb.append(", commentCount='").append(commentCount).append('\'');
        sb.append(", seederCount='").append(seederCount).append('\'');
        sb.append(", leecherCount='").append(leecherCount).append('\'');
        sb.append(", downloadCount='").append(downloadCount).append('\'');
        sb.append(", speed='").append(speed).append('\'');
        sb.append(", size='").append(size).append('\'');
        sb.append(", fileCount='").append(fileCount).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", infoBarTitle='").append(infoBarTitle).append('\'');
        sb.append(", releaseDate='").append(releaseDate).append('\'');
        sb.append(", director='").append(director).append('\'');
        sb.append(", actors='").append(actors).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", length='").append(length).append('\'');
        sb.append(", tags='").append(tags).append('\'');
        sb.append(", imdbRating='").append(imdbRating).append('\'');
        sb.append(", imdbURL='").append(imdbURL).append('\'');
        sb.append(", otherURL='").append(otherURL).append('\'');
        sb.append(", mafabURL='").append(mafabURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

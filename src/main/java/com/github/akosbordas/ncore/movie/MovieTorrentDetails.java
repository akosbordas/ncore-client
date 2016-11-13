package com.github.akosbordas.ncore.movie;

import com.github.akosbordas.ncore.TorrentDetails;
import org.jsoup.nodes.Document;

public class MovieTorrentDetails extends TorrentDetails {

    private String infobar_title;
    private String releaseDate;
    private String director;
    private String actors;
    private String country;
    private String length;
    private String tags;
    private String imdbRating;
    private String imdbURL;
    private String otherURL;
    private String mafabURL;


    public String getInfobarTitle() {
        return infobar_title;
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

        infobar_title = document.select("div.infobar_title").text();
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
        return  super.toString() +
                ", infobar_title='" + infobar_title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", director='" + director + '\'' +
                ", actors='" + actors + '\'' +
                ", country='" + country + '\'' +
                ", length='" + length + '\'' +
                ", tags='" + tags + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbURL='" + imdbURL + '\'' +
                ", otherURL='" + otherURL + '\'' +
                ", mafabURL='" + mafabURL + '\'' ;
    }
}

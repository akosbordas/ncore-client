package com.github.akosbordas.ncore.movie;

public class HdMovieTorrentDetails extends MovieTorrentDetails {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HdMovieTorrentDetails{");
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

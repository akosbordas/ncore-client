package com.github.akosbordas.ncore.game;

public class IsoGameTorrentDetails extends GameTorrentDetails {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IsoGameTorrentDetails{");
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
        sb.append('}');
        return sb.toString();
    }
}

package com.github.akosbordas.ncore.music;

public class Mp3MusicTorrentDetails extends MusicTorrentDetails{

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mp3MusicTorrentDetails{");
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
        sb.append(", tags='").append(tags).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

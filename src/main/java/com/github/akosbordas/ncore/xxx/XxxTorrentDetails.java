package com.github.akosbordas.ncore.xxx;

import com.github.akosbordas.ncore.TorrentDetails;
import org.jsoup.nodes.Document;

public class XxxTorrentDetails extends TorrentDetails {

    @Override
    public void customParse(Document document) {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("XxxTorrentDetails{");
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

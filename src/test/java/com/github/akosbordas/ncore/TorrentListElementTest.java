package com.github.akosbordas.ncore;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TorrentListElementTest {

    @Test
    public void shouldFillOutPropertiesCorrectly() throws Exception {
        TorrentListElement listElement = new TorrentListElement("Inception.2010.iNTERNAL.BDRip.x264-REGRET", "torrents.php?action=details&id=2009695");
        TorrentListElement listElement2 = new TorrentListElement("Inception.2010.iNTERNAL.BDRip.x264-REGRET", "torrents.php?action=details&id=2009695");
        assertThat(listElement.getName()).isEqualTo("Inception.2010.iNTERNAL.BDRip.x264-REGRET");
        assertThat(listElement.getId()).isEqualTo("2009695");
        assertThat(listElement.getUrl()).isEqualTo("https://ncore.cc/torrents.php?action=details&id=2009695");
        assertThat(listElement).isEqualTo(listElement2);
        assertThat(listElement.hashCode()).isEqualTo(listElement2.hashCode());
    }
}
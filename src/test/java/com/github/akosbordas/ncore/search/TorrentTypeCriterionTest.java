package com.github.akosbordas.ncore.search;

import com.github.akosbordas.ncore.TorrentType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TorrentTypeCriterionTest {

    @Test
    public void hashCodeShouldBeCorrect() throws Exception {
        TorrentTypeCriterion type1 = new TorrentTypeCriterion(new TorrentType(TorrentType.MOVIE_HD));
        TorrentTypeCriterion type2 = new TorrentTypeCriterion(new TorrentType(TorrentType.MOVIE_HD));
        assertThat(type1.hashCode()).isEqualTo(type2.hashCode());
        type2 = new TorrentTypeCriterion(new TorrentType(TorrentType.MOVIE_DVD));
        assertThat(type1.hashCode()).isNotEqualTo(type2.hashCode());
    }

    @Test
    public void equalsShouldBeCorrect() throws Exception {
        TorrentTypeCriterion type1 = new TorrentTypeCriterion(new TorrentType(TorrentType.MOVIE_HD));
        TorrentTypeCriterion type2 = new TorrentTypeCriterion(new TorrentType(TorrentType.MOVIE_HD));
        TorrentTypeCriterion type3 = type1;
        TorrentTypeCriterion type4 = new TorrentTypeCriterion(new TorrentType(TorrentType.MOVIE_DVD));

        assertThat(type1).isEqualTo(type3);
        assertThat(type1).isEqualTo(type2);
        assertThat(type1).isNotEqualTo(type4);
        assertThat(type1).isNotEqualTo(new Object());

        assertThat(new TorrentTypeCriterion(null)).isEqualTo(new TorrentTypeCriterion(null));
    }
}
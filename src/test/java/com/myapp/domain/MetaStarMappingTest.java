package com.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaStarMappingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetaStarMapping.class);
        MetaStarMapping metaStarMapping1 = new MetaStarMapping();
        metaStarMapping1.setId("id1");
        MetaStarMapping metaStarMapping2 = new MetaStarMapping();
        metaStarMapping2.setId(metaStarMapping1.getId());
        assertThat(metaStarMapping1).isEqualTo(metaStarMapping2);
        metaStarMapping2.setId("id2");
        assertThat(metaStarMapping1).isNotEqualTo(metaStarMapping2);
        metaStarMapping1.setId(null);
        assertThat(metaStarMapping1).isNotEqualTo(metaStarMapping2);
    }
}

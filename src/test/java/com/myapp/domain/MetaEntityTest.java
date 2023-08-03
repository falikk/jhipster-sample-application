package com.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetaEntity.class);
        MetaEntity metaEntity1 = new MetaEntity();
        metaEntity1.setId("id1");
        MetaEntity metaEntity2 = new MetaEntity();
        metaEntity2.setId(metaEntity1.getId());
        assertThat(metaEntity1).isEqualTo(metaEntity2);
        metaEntity2.setId("id2");
        assertThat(metaEntity1).isNotEqualTo(metaEntity2);
        metaEntity1.setId(null);
        assertThat(metaEntity1).isNotEqualTo(metaEntity2);
    }
}

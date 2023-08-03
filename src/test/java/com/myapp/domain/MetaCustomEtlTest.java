package com.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaCustomEtlTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetaCustomEtl.class);
        MetaCustomEtl metaCustomEtl1 = new MetaCustomEtl();
        metaCustomEtl1.setId("id1");
        MetaCustomEtl metaCustomEtl2 = new MetaCustomEtl();
        metaCustomEtl2.setId(metaCustomEtl1.getId());
        assertThat(metaCustomEtl1).isEqualTo(metaCustomEtl2);
        metaCustomEtl2.setId("id2");
        assertThat(metaCustomEtl1).isNotEqualTo(metaCustomEtl2);
        metaCustomEtl1.setId(null);
        assertThat(metaCustomEtl1).isNotEqualTo(metaCustomEtl2);
    }
}

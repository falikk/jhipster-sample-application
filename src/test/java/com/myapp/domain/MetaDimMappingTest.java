package com.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaDimMappingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetaDimMapping.class);
        MetaDimMapping metaDimMapping1 = new MetaDimMapping();
        metaDimMapping1.setId("id1");
        MetaDimMapping metaDimMapping2 = new MetaDimMapping();
        metaDimMapping2.setId(metaDimMapping1.getId());
        assertThat(metaDimMapping1).isEqualTo(metaDimMapping2);
        metaDimMapping2.setId("id2");
        assertThat(metaDimMapping1).isNotEqualTo(metaDimMapping2);
        metaDimMapping1.setId(null);
        assertThat(metaDimMapping1).isNotEqualTo(metaDimMapping2);
    }
}

package com.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaDwhMappingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetaDwhMapping.class);
        MetaDwhMapping metaDwhMapping1 = new MetaDwhMapping();
        metaDwhMapping1.setId("id1");
        MetaDwhMapping metaDwhMapping2 = new MetaDwhMapping();
        metaDwhMapping2.setId(metaDwhMapping1.getId());
        assertThat(metaDwhMapping1).isEqualTo(metaDwhMapping2);
        metaDwhMapping2.setId("id2");
        assertThat(metaDwhMapping1).isNotEqualTo(metaDwhMapping2);
        metaDwhMapping1.setId(null);
        assertThat(metaDwhMapping1).isNotEqualTo(metaDwhMapping2);
    }
}

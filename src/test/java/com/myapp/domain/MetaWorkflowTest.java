package com.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaWorkflowTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetaWorkflow.class);
        MetaWorkflow metaWorkflow1 = new MetaWorkflow();
        metaWorkflow1.setId("id1");
        MetaWorkflow metaWorkflow2 = new MetaWorkflow();
        metaWorkflow2.setId(metaWorkflow1.getId());
        assertThat(metaWorkflow1).isEqualTo(metaWorkflow2);
        metaWorkflow2.setId("id2");
        assertThat(metaWorkflow1).isNotEqualTo(metaWorkflow2);
        metaWorkflow1.setId(null);
        assertThat(metaWorkflow1).isNotEqualTo(metaWorkflow2);
    }
}

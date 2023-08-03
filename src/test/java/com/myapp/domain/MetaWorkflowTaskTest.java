package com.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaWorkflowTaskTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MetaWorkflowTask.class);
        MetaWorkflowTask metaWorkflowTask1 = new MetaWorkflowTask();
        metaWorkflowTask1.setId("id1");
        MetaWorkflowTask metaWorkflowTask2 = new MetaWorkflowTask();
        metaWorkflowTask2.setId(metaWorkflowTask1.getId());
        assertThat(metaWorkflowTask1).isEqualTo(metaWorkflowTask2);
        metaWorkflowTask2.setId("id2");
        assertThat(metaWorkflowTask1).isNotEqualTo(metaWorkflowTask2);
        metaWorkflowTask1.setId(null);
        assertThat(metaWorkflowTask1).isNotEqualTo(metaWorkflowTask2);
    }
}

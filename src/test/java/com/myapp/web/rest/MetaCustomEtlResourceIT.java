package com.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.myapp.IntegrationTest;
import com.myapp.domain.MetaCustomEtl;
import com.myapp.repository.MetaCustomEtlRepository;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link MetaCustomEtlResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class MetaCustomEtlResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SQL_STATEMENT = "AAAAAAAAAA";
    private static final String UPDATED_SQL_STATEMENT = "BBBBBBBBBB";

    private static final String DEFAULT_CREATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_CREATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_TS = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_TS = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATED_BY = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_BY = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATED_TS = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_TS = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/meta-custom-etls";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private MetaCustomEtlRepository metaCustomEtlRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMetaCustomEtlMockMvc;

    private MetaCustomEtl metaCustomEtl;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MetaCustomEtl createEntity(EntityManager em) {
        MetaCustomEtl metaCustomEtl = new MetaCustomEtl()
            .name(DEFAULT_NAME)
            .sqlStatement(DEFAULT_SQL_STATEMENT)
            .createdBy(DEFAULT_CREATED_BY)
            .createdTs(DEFAULT_CREATED_TS)
            .updatedBy(DEFAULT_UPDATED_BY)
            .updatedTs(DEFAULT_UPDATED_TS);
        return metaCustomEtl;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MetaCustomEtl createUpdatedEntity(EntityManager em) {
        MetaCustomEtl metaCustomEtl = new MetaCustomEtl()
            .name(UPDATED_NAME)
            .sqlStatement(UPDATED_SQL_STATEMENT)
            .createdBy(UPDATED_CREATED_BY)
            .createdTs(UPDATED_CREATED_TS)
            .updatedBy(UPDATED_UPDATED_BY)
            .updatedTs(UPDATED_UPDATED_TS);
        return metaCustomEtl;
    }

    @BeforeEach
    public void initTest() {
        metaCustomEtl = createEntity(em);
    }

    @Test
    @Transactional
    void getAllMetaCustomEtls() throws Exception {
        // Initialize the database
        metaCustomEtl.setId(UUID.randomUUID().toString());
        metaCustomEtlRepository.saveAndFlush(metaCustomEtl);

        // Get all the metaCustomEtlList
        restMetaCustomEtlMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(metaCustomEtl.getId())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].sqlStatement").value(hasItem(DEFAULT_SQL_STATEMENT)))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].createdTs").value(hasItem(DEFAULT_CREATED_TS.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY)))
            .andExpect(jsonPath("$.[*].updatedTs").value(hasItem(DEFAULT_UPDATED_TS.toString())));
    }

    @Test
    @Transactional
    void getMetaCustomEtl() throws Exception {
        // Initialize the database
        metaCustomEtl.setId(UUID.randomUUID().toString());
        metaCustomEtlRepository.saveAndFlush(metaCustomEtl);

        // Get the metaCustomEtl
        restMetaCustomEtlMockMvc
            .perform(get(ENTITY_API_URL_ID, metaCustomEtl.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(metaCustomEtl.getId()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.sqlStatement").value(DEFAULT_SQL_STATEMENT))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.createdTs").value(DEFAULT_CREATED_TS.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY))
            .andExpect(jsonPath("$.updatedTs").value(DEFAULT_UPDATED_TS.toString()));
    }

    @Test
    @Transactional
    void getNonExistingMetaCustomEtl() throws Exception {
        // Get the metaCustomEtl
        restMetaCustomEtlMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}

package com.myapp.web.rest;

import com.myapp.domain.MetaEntity;
import com.myapp.repository.MetaEntityRepository;
import com.myapp.service.MetaEntityService;
import com.myapp.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.myapp.domain.MetaEntity}.
 */
@RestController
@RequestMapping("/api")
public class MetaEntityResource {

    private final Logger log = LoggerFactory.getLogger(MetaEntityResource.class);

    private final MetaEntityService metaEntityService;

    private final MetaEntityRepository metaEntityRepository;

    public MetaEntityResource(MetaEntityService metaEntityService, MetaEntityRepository metaEntityRepository) {
        this.metaEntityService = metaEntityService;
        this.metaEntityRepository = metaEntityRepository;
    }

    /**
     * {@code GET  /meta-entities} : get all the metaEntities.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metaEntities in body.
     */
    @GetMapping("/meta-entities")
    public List<MetaEntity> getAllMetaEntities() {
        log.debug("REST request to get all MetaEntities");
        return metaEntityService.findAll();
    }

    /**
     * {@code GET  /meta-entities/:id} : get the "id" metaEntity.
     *
     * @param id the id of the metaEntity to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaEntity, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meta-entities/{id}")
    public ResponseEntity<MetaEntity> getMetaEntity(@PathVariable String id) {
        log.debug("REST request to get MetaEntity : {}", id);
        Optional<MetaEntity> metaEntity = metaEntityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaEntity);
    }
}

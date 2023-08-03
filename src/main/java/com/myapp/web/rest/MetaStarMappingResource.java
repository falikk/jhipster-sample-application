package com.myapp.web.rest;

import com.myapp.domain.MetaStarMapping;
import com.myapp.repository.MetaStarMappingRepository;
import com.myapp.service.MetaStarMappingService;
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
 * REST controller for managing {@link com.myapp.domain.MetaStarMapping}.
 */
@RestController
@RequestMapping("/api")
public class MetaStarMappingResource {

    private final Logger log = LoggerFactory.getLogger(MetaStarMappingResource.class);

    private final MetaStarMappingService metaStarMappingService;

    private final MetaStarMappingRepository metaStarMappingRepository;

    public MetaStarMappingResource(MetaStarMappingService metaStarMappingService, MetaStarMappingRepository metaStarMappingRepository) {
        this.metaStarMappingService = metaStarMappingService;
        this.metaStarMappingRepository = metaStarMappingRepository;
    }

    /**
     * {@code GET  /meta-star-mappings} : get all the metaStarMappings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metaStarMappings in body.
     */
    @GetMapping("/meta-star-mappings")
    public List<MetaStarMapping> getAllMetaStarMappings() {
        log.debug("REST request to get all MetaStarMappings");
        return metaStarMappingService.findAll();
    }

    /**
     * {@code GET  /meta-star-mappings/:id} : get the "id" metaStarMapping.
     *
     * @param id the id of the metaStarMapping to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaStarMapping, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meta-star-mappings/{id}")
    public ResponseEntity<MetaStarMapping> getMetaStarMapping(@PathVariable String id) {
        log.debug("REST request to get MetaStarMapping : {}", id);
        Optional<MetaStarMapping> metaStarMapping = metaStarMappingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaStarMapping);
    }
}

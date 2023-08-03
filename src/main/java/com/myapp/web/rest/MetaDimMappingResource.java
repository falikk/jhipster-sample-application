package com.myapp.web.rest;

import com.myapp.domain.MetaDimMapping;
import com.myapp.repository.MetaDimMappingRepository;
import com.myapp.service.MetaDimMappingService;
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
 * REST controller for managing {@link com.myapp.domain.MetaDimMapping}.
 */
@RestController
@RequestMapping("/api")
public class MetaDimMappingResource {

    private final Logger log = LoggerFactory.getLogger(MetaDimMappingResource.class);

    private final MetaDimMappingService metaDimMappingService;

    private final MetaDimMappingRepository metaDimMappingRepository;

    public MetaDimMappingResource(MetaDimMappingService metaDimMappingService, MetaDimMappingRepository metaDimMappingRepository) {
        this.metaDimMappingService = metaDimMappingService;
        this.metaDimMappingRepository = metaDimMappingRepository;
    }

    /**
     * {@code GET  /meta-dim-mappings} : get all the metaDimMappings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metaDimMappings in body.
     */
    @GetMapping("/meta-dim-mappings")
    public List<MetaDimMapping> getAllMetaDimMappings() {
        log.debug("REST request to get all MetaDimMappings");
        return metaDimMappingService.findAll();
    }

    /**
     * {@code GET  /meta-dim-mappings/:id} : get the "id" metaDimMapping.
     *
     * @param id the id of the metaDimMapping to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaDimMapping, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meta-dim-mappings/{id}")
    public ResponseEntity<MetaDimMapping> getMetaDimMapping(@PathVariable String id) {
        log.debug("REST request to get MetaDimMapping : {}", id);
        Optional<MetaDimMapping> metaDimMapping = metaDimMappingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaDimMapping);
    }
}

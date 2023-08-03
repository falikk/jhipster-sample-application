package com.myapp.web.rest;

import com.myapp.domain.MetaDwhMapping;
import com.myapp.repository.MetaDwhMappingRepository;
import com.myapp.service.MetaDwhMappingService;
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
 * REST controller for managing {@link com.myapp.domain.MetaDwhMapping}.
 */
@RestController
@RequestMapping("/api")
public class MetaDwhMappingResource {

    private final Logger log = LoggerFactory.getLogger(MetaDwhMappingResource.class);

    private final MetaDwhMappingService metaDwhMappingService;

    private final MetaDwhMappingRepository metaDwhMappingRepository;

    public MetaDwhMappingResource(MetaDwhMappingService metaDwhMappingService, MetaDwhMappingRepository metaDwhMappingRepository) {
        this.metaDwhMappingService = metaDwhMappingService;
        this.metaDwhMappingRepository = metaDwhMappingRepository;
    }

    /**
     * {@code GET  /meta-dwh-mappings} : get all the metaDwhMappings.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metaDwhMappings in body.
     */
    @GetMapping("/meta-dwh-mappings")
    public List<MetaDwhMapping> getAllMetaDwhMappings() {
        log.debug("REST request to get all MetaDwhMappings");
        return metaDwhMappingService.findAll();
    }

    /**
     * {@code GET  /meta-dwh-mappings/:id} : get the "id" metaDwhMapping.
     *
     * @param id the id of the metaDwhMapping to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaDwhMapping, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meta-dwh-mappings/{id}")
    public ResponseEntity<MetaDwhMapping> getMetaDwhMapping(@PathVariable String id) {
        log.debug("REST request to get MetaDwhMapping : {}", id);
        Optional<MetaDwhMapping> metaDwhMapping = metaDwhMappingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaDwhMapping);
    }
}

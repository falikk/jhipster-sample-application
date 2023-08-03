package com.myapp.web.rest;

import com.myapp.domain.MetaCustomEtl;
import com.myapp.repository.MetaCustomEtlRepository;
import com.myapp.service.MetaCustomEtlService;
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
 * REST controller for managing {@link com.myapp.domain.MetaCustomEtl}.
 */
@RestController
@RequestMapping("/api")
public class MetaCustomEtlResource {

    private final Logger log = LoggerFactory.getLogger(MetaCustomEtlResource.class);

    private final MetaCustomEtlService metaCustomEtlService;

    private final MetaCustomEtlRepository metaCustomEtlRepository;

    public MetaCustomEtlResource(MetaCustomEtlService metaCustomEtlService, MetaCustomEtlRepository metaCustomEtlRepository) {
        this.metaCustomEtlService = metaCustomEtlService;
        this.metaCustomEtlRepository = metaCustomEtlRepository;
    }

    /**
     * {@code GET  /meta-custom-etls} : get all the metaCustomEtls.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metaCustomEtls in body.
     */
    @GetMapping("/meta-custom-etls")
    public List<MetaCustomEtl> getAllMetaCustomEtls() {
        log.debug("REST request to get all MetaCustomEtls");
        return metaCustomEtlService.findAll();
    }

    /**
     * {@code GET  /meta-custom-etls/:id} : get the "id" metaCustomEtl.
     *
     * @param id the id of the metaCustomEtl to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaCustomEtl, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meta-custom-etls/{id}")
    public ResponseEntity<MetaCustomEtl> getMetaCustomEtl(@PathVariable String id) {
        log.debug("REST request to get MetaCustomEtl : {}", id);
        Optional<MetaCustomEtl> metaCustomEtl = metaCustomEtlService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaCustomEtl);
    }
}

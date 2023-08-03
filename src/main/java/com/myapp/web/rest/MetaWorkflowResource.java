package com.myapp.web.rest;

import com.myapp.domain.MetaWorkflow;
import com.myapp.repository.MetaWorkflowRepository;
import com.myapp.service.MetaWorkflowService;
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
 * REST controller for managing {@link com.myapp.domain.MetaWorkflow}.
 */
@RestController
@RequestMapping("/api")
public class MetaWorkflowResource {

    private final Logger log = LoggerFactory.getLogger(MetaWorkflowResource.class);

    private final MetaWorkflowService metaWorkflowService;

    private final MetaWorkflowRepository metaWorkflowRepository;

    public MetaWorkflowResource(MetaWorkflowService metaWorkflowService, MetaWorkflowRepository metaWorkflowRepository) {
        this.metaWorkflowService = metaWorkflowService;
        this.metaWorkflowRepository = metaWorkflowRepository;
    }

    /**
     * {@code GET  /meta-workflows} : get all the metaWorkflows.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metaWorkflows in body.
     */
    @GetMapping("/meta-workflows")
    public List<MetaWorkflow> getAllMetaWorkflows() {
        log.debug("REST request to get all MetaWorkflows");
        return metaWorkflowService.findAll();
    }

    /**
     * {@code GET  /meta-workflows/:id} : get the "id" metaWorkflow.
     *
     * @param id the id of the metaWorkflow to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaWorkflow, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meta-workflows/{id}")
    public ResponseEntity<MetaWorkflow> getMetaWorkflow(@PathVariable String id) {
        log.debug("REST request to get MetaWorkflow : {}", id);
        Optional<MetaWorkflow> metaWorkflow = metaWorkflowService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaWorkflow);
    }
}

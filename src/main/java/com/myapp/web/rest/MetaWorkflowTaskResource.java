package com.myapp.web.rest;

import com.myapp.domain.MetaWorkflowTask;
import com.myapp.repository.MetaWorkflowTaskRepository;
import com.myapp.service.MetaWorkflowTaskService;
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
 * REST controller for managing {@link com.myapp.domain.MetaWorkflowTask}.
 */
@RestController
@RequestMapping("/api")
public class MetaWorkflowTaskResource {

    private final Logger log = LoggerFactory.getLogger(MetaWorkflowTaskResource.class);

    private final MetaWorkflowTaskService metaWorkflowTaskService;

    private final MetaWorkflowTaskRepository metaWorkflowTaskRepository;

    public MetaWorkflowTaskResource(
        MetaWorkflowTaskService metaWorkflowTaskService,
        MetaWorkflowTaskRepository metaWorkflowTaskRepository
    ) {
        this.metaWorkflowTaskService = metaWorkflowTaskService;
        this.metaWorkflowTaskRepository = metaWorkflowTaskRepository;
    }

    /**
     * {@code GET  /meta-workflow-tasks} : get all the metaWorkflowTasks.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metaWorkflowTasks in body.
     */
    @GetMapping("/meta-workflow-tasks")
    public List<MetaWorkflowTask> getAllMetaWorkflowTasks() {
        log.debug("REST request to get all MetaWorkflowTasks");
        return metaWorkflowTaskService.findAll();
    }

    /**
     * {@code GET  /meta-workflow-tasks/:id} : get the "id" metaWorkflowTask.
     *
     * @param id the id of the metaWorkflowTask to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaWorkflowTask, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meta-workflow-tasks/{id}")
    public ResponseEntity<MetaWorkflowTask> getMetaWorkflowTask(@PathVariable String id) {
        log.debug("REST request to get MetaWorkflowTask : {}", id);
        Optional<MetaWorkflowTask> metaWorkflowTask = metaWorkflowTaskService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaWorkflowTask);
    }
}

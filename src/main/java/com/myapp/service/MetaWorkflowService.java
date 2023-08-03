package com.myapp.service;

import com.myapp.domain.MetaWorkflow;
import com.myapp.repository.MetaWorkflowRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MetaWorkflow}.
 */
@Service
@Transactional
public class MetaWorkflowService {

    private final Logger log = LoggerFactory.getLogger(MetaWorkflowService.class);

    private final MetaWorkflowRepository metaWorkflowRepository;

    public MetaWorkflowService(MetaWorkflowRepository metaWorkflowRepository) {
        this.metaWorkflowRepository = metaWorkflowRepository;
    }

    /**
     * Save a metaWorkflow.
     *
     * @param metaWorkflow the entity to save.
     * @return the persisted entity.
     */
    public MetaWorkflow save(MetaWorkflow metaWorkflow) {
        log.debug("Request to save MetaWorkflow : {}", metaWorkflow);
        return metaWorkflowRepository.save(metaWorkflow);
    }

    /**
     * Update a metaWorkflow.
     *
     * @param metaWorkflow the entity to save.
     * @return the persisted entity.
     */
    public MetaWorkflow update(MetaWorkflow metaWorkflow) {
        log.debug("Request to update MetaWorkflow : {}", metaWorkflow);
        metaWorkflow.setIsPersisted();
        return metaWorkflowRepository.save(metaWorkflow);
    }

    /**
     * Partially update a metaWorkflow.
     *
     * @param metaWorkflow the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaWorkflow> partialUpdate(MetaWorkflow metaWorkflow) {
        log.debug("Request to partially update MetaWorkflow : {}", metaWorkflow);

        return metaWorkflowRepository
            .findById(metaWorkflow.getId())
            .map(existingMetaWorkflow -> {
                if (metaWorkflow.getName() != null) {
                    existingMetaWorkflow.setName(metaWorkflow.getName());
                }
                if (metaWorkflow.getDefinition() != null) {
                    existingMetaWorkflow.setDefinition(metaWorkflow.getDefinition());
                }
                if (metaWorkflow.getCreatedBy() != null) {
                    existingMetaWorkflow.setCreatedBy(metaWorkflow.getCreatedBy());
                }
                if (metaWorkflow.getCreatedTs() != null) {
                    existingMetaWorkflow.setCreatedTs(metaWorkflow.getCreatedTs());
                }
                if (metaWorkflow.getUpdatedBy() != null) {
                    existingMetaWorkflow.setUpdatedBy(metaWorkflow.getUpdatedBy());
                }
                if (metaWorkflow.getUpdatedTs() != null) {
                    existingMetaWorkflow.setUpdatedTs(metaWorkflow.getUpdatedTs());
                }

                return existingMetaWorkflow;
            })
            .map(metaWorkflowRepository::save);
    }

    /**
     * Get all the metaWorkflows.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MetaWorkflow> findAll() {
        log.debug("Request to get all MetaWorkflows");
        return metaWorkflowRepository.findAll();
    }

    /**
     * Get one metaWorkflow by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaWorkflow> findOne(String id) {
        log.debug("Request to get MetaWorkflow : {}", id);
        return metaWorkflowRepository.findById(id);
    }

    /**
     * Delete the metaWorkflow by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete MetaWorkflow : {}", id);
        metaWorkflowRepository.deleteById(id);
    }
}

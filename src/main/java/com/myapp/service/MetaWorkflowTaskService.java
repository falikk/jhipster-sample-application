package com.myapp.service;

import com.myapp.domain.MetaWorkflowTask;
import com.myapp.repository.MetaWorkflowTaskRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MetaWorkflowTask}.
 */
@Service
@Transactional
public class MetaWorkflowTaskService {

    private final Logger log = LoggerFactory.getLogger(MetaWorkflowTaskService.class);

    private final MetaWorkflowTaskRepository metaWorkflowTaskRepository;

    public MetaWorkflowTaskService(MetaWorkflowTaskRepository metaWorkflowTaskRepository) {
        this.metaWorkflowTaskRepository = metaWorkflowTaskRepository;
    }

    /**
     * Save a metaWorkflowTask.
     *
     * @param metaWorkflowTask the entity to save.
     * @return the persisted entity.
     */
    public MetaWorkflowTask save(MetaWorkflowTask metaWorkflowTask) {
        log.debug("Request to save MetaWorkflowTask : {}", metaWorkflowTask);
        return metaWorkflowTaskRepository.save(metaWorkflowTask);
    }

    /**
     * Update a metaWorkflowTask.
     *
     * @param metaWorkflowTask the entity to save.
     * @return the persisted entity.
     */
    public MetaWorkflowTask update(MetaWorkflowTask metaWorkflowTask) {
        log.debug("Request to update MetaWorkflowTask : {}", metaWorkflowTask);
        metaWorkflowTask.setIsPersisted();
        return metaWorkflowTaskRepository.save(metaWorkflowTask);
    }

    /**
     * Partially update a metaWorkflowTask.
     *
     * @param metaWorkflowTask the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaWorkflowTask> partialUpdate(MetaWorkflowTask metaWorkflowTask) {
        log.debug("Request to partially update MetaWorkflowTask : {}", metaWorkflowTask);

        return metaWorkflowTaskRepository
            .findById(metaWorkflowTask.getId())
            .map(existingMetaWorkflowTask -> {
                if (metaWorkflowTask.getName() != null) {
                    existingMetaWorkflowTask.setName(metaWorkflowTask.getName());
                }
                if (metaWorkflowTask.getType() != null) {
                    existingMetaWorkflowTask.setType(metaWorkflowTask.getType());
                }
                if (metaWorkflowTask.getDefinition() != null) {
                    existingMetaWorkflowTask.setDefinition(metaWorkflowTask.getDefinition());
                }
                if (metaWorkflowTask.getCreatedBy() != null) {
                    existingMetaWorkflowTask.setCreatedBy(metaWorkflowTask.getCreatedBy());
                }
                if (metaWorkflowTask.getCreatedTs() != null) {
                    existingMetaWorkflowTask.setCreatedTs(metaWorkflowTask.getCreatedTs());
                }
                if (metaWorkflowTask.getUpdatedBy() != null) {
                    existingMetaWorkflowTask.setUpdatedBy(metaWorkflowTask.getUpdatedBy());
                }
                if (metaWorkflowTask.getUpdatedTs() != null) {
                    existingMetaWorkflowTask.setUpdatedTs(metaWorkflowTask.getUpdatedTs());
                }

                return existingMetaWorkflowTask;
            })
            .map(metaWorkflowTaskRepository::save);
    }

    /**
     * Get all the metaWorkflowTasks.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MetaWorkflowTask> findAll() {
        log.debug("Request to get all MetaWorkflowTasks");
        return metaWorkflowTaskRepository.findAll();
    }

    /**
     * Get one metaWorkflowTask by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaWorkflowTask> findOne(String id) {
        log.debug("Request to get MetaWorkflowTask : {}", id);
        return metaWorkflowTaskRepository.findById(id);
    }

    /**
     * Delete the metaWorkflowTask by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete MetaWorkflowTask : {}", id);
        metaWorkflowTaskRepository.deleteById(id);
    }
}

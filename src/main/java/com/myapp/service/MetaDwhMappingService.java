package com.myapp.service;

import com.myapp.domain.MetaDwhMapping;
import com.myapp.repository.MetaDwhMappingRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MetaDwhMapping}.
 */
@Service
@Transactional
public class MetaDwhMappingService {

    private final Logger log = LoggerFactory.getLogger(MetaDwhMappingService.class);

    private final MetaDwhMappingRepository metaDwhMappingRepository;

    public MetaDwhMappingService(MetaDwhMappingRepository metaDwhMappingRepository) {
        this.metaDwhMappingRepository = metaDwhMappingRepository;
    }

    /**
     * Save a metaDwhMapping.
     *
     * @param metaDwhMapping the entity to save.
     * @return the persisted entity.
     */
    public MetaDwhMapping save(MetaDwhMapping metaDwhMapping) {
        log.debug("Request to save MetaDwhMapping : {}", metaDwhMapping);
        return metaDwhMappingRepository.save(metaDwhMapping);
    }

    /**
     * Update a metaDwhMapping.
     *
     * @param metaDwhMapping the entity to save.
     * @return the persisted entity.
     */
    public MetaDwhMapping update(MetaDwhMapping metaDwhMapping) {
        log.debug("Request to update MetaDwhMapping : {}", metaDwhMapping);
        metaDwhMapping.setIsPersisted();
        return metaDwhMappingRepository.save(metaDwhMapping);
    }

    /**
     * Partially update a metaDwhMapping.
     *
     * @param metaDwhMapping the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaDwhMapping> partialUpdate(MetaDwhMapping metaDwhMapping) {
        log.debug("Request to partially update MetaDwhMapping : {}", metaDwhMapping);

        return metaDwhMappingRepository
            .findById(metaDwhMapping.getId())
            .map(existingMetaDwhMapping -> {
                if (metaDwhMapping.getName() != null) {
                    existingMetaDwhMapping.setName(metaDwhMapping.getName());
                }
                if (metaDwhMapping.getEntityId() != null) {
                    existingMetaDwhMapping.setEntityId(metaDwhMapping.getEntityId());
                }
                if (metaDwhMapping.getDefinition() != null) {
                    existingMetaDwhMapping.setDefinition(metaDwhMapping.getDefinition());
                }
                if (metaDwhMapping.getCreatedBy() != null) {
                    existingMetaDwhMapping.setCreatedBy(metaDwhMapping.getCreatedBy());
                }
                if (metaDwhMapping.getCreatedTs() != null) {
                    existingMetaDwhMapping.setCreatedTs(metaDwhMapping.getCreatedTs());
                }
                if (metaDwhMapping.getUpdatedBy() != null) {
                    existingMetaDwhMapping.setUpdatedBy(metaDwhMapping.getUpdatedBy());
                }
                if (metaDwhMapping.getUpdatedTs() != null) {
                    existingMetaDwhMapping.setUpdatedTs(metaDwhMapping.getUpdatedTs());
                }

                return existingMetaDwhMapping;
            })
            .map(metaDwhMappingRepository::save);
    }

    /**
     * Get all the metaDwhMappings.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MetaDwhMapping> findAll() {
        log.debug("Request to get all MetaDwhMappings");
        return metaDwhMappingRepository.findAll();
    }

    /**
     * Get one metaDwhMapping by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaDwhMapping> findOne(String id) {
        log.debug("Request to get MetaDwhMapping : {}", id);
        return metaDwhMappingRepository.findById(id);
    }

    /**
     * Delete the metaDwhMapping by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete MetaDwhMapping : {}", id);
        metaDwhMappingRepository.deleteById(id);
    }
}

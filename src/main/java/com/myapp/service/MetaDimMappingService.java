package com.myapp.service;

import com.myapp.domain.MetaDimMapping;
import com.myapp.repository.MetaDimMappingRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MetaDimMapping}.
 */
@Service
@Transactional
public class MetaDimMappingService {

    private final Logger log = LoggerFactory.getLogger(MetaDimMappingService.class);

    private final MetaDimMappingRepository metaDimMappingRepository;

    public MetaDimMappingService(MetaDimMappingRepository metaDimMappingRepository) {
        this.metaDimMappingRepository = metaDimMappingRepository;
    }

    /**
     * Save a metaDimMapping.
     *
     * @param metaDimMapping the entity to save.
     * @return the persisted entity.
     */
    public MetaDimMapping save(MetaDimMapping metaDimMapping) {
        log.debug("Request to save MetaDimMapping : {}", metaDimMapping);
        return metaDimMappingRepository.save(metaDimMapping);
    }

    /**
     * Update a metaDimMapping.
     *
     * @param metaDimMapping the entity to save.
     * @return the persisted entity.
     */
    public MetaDimMapping update(MetaDimMapping metaDimMapping) {
        log.debug("Request to update MetaDimMapping : {}", metaDimMapping);
        metaDimMapping.setIsPersisted();
        return metaDimMappingRepository.save(metaDimMapping);
    }

    /**
     * Partially update a metaDimMapping.
     *
     * @param metaDimMapping the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaDimMapping> partialUpdate(MetaDimMapping metaDimMapping) {
        log.debug("Request to partially update MetaDimMapping : {}", metaDimMapping);

        return metaDimMappingRepository
            .findById(metaDimMapping.getId())
            .map(existingMetaDimMapping -> {
                if (metaDimMapping.getName() != null) {
                    existingMetaDimMapping.setName(metaDimMapping.getName());
                }
                if (metaDimMapping.getEntityId() != null) {
                    existingMetaDimMapping.setEntityId(metaDimMapping.getEntityId());
                }
                if (metaDimMapping.getDefinition() != null) {
                    existingMetaDimMapping.setDefinition(metaDimMapping.getDefinition());
                }
                if (metaDimMapping.getCreatedBy() != null) {
                    existingMetaDimMapping.setCreatedBy(metaDimMapping.getCreatedBy());
                }
                if (metaDimMapping.getCreatedTs() != null) {
                    existingMetaDimMapping.setCreatedTs(metaDimMapping.getCreatedTs());
                }
                if (metaDimMapping.getUpdatedBy() != null) {
                    existingMetaDimMapping.setUpdatedBy(metaDimMapping.getUpdatedBy());
                }
                if (metaDimMapping.getUpdatedTs() != null) {
                    existingMetaDimMapping.setUpdatedTs(metaDimMapping.getUpdatedTs());
                }

                return existingMetaDimMapping;
            })
            .map(metaDimMappingRepository::save);
    }

    /**
     * Get all the metaDimMappings.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MetaDimMapping> findAll() {
        log.debug("Request to get all MetaDimMappings");
        return metaDimMappingRepository.findAll();
    }

    /**
     * Get one metaDimMapping by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaDimMapping> findOne(String id) {
        log.debug("Request to get MetaDimMapping : {}", id);
        return metaDimMappingRepository.findById(id);
    }

    /**
     * Delete the metaDimMapping by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete MetaDimMapping : {}", id);
        metaDimMappingRepository.deleteById(id);
    }
}

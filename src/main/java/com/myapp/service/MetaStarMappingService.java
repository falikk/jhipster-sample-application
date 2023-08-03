package com.myapp.service;

import com.myapp.domain.MetaStarMapping;
import com.myapp.repository.MetaStarMappingRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MetaStarMapping}.
 */
@Service
@Transactional
public class MetaStarMappingService {

    private final Logger log = LoggerFactory.getLogger(MetaStarMappingService.class);

    private final MetaStarMappingRepository metaStarMappingRepository;

    public MetaStarMappingService(MetaStarMappingRepository metaStarMappingRepository) {
        this.metaStarMappingRepository = metaStarMappingRepository;
    }

    /**
     * Save a metaStarMapping.
     *
     * @param metaStarMapping the entity to save.
     * @return the persisted entity.
     */
    public MetaStarMapping save(MetaStarMapping metaStarMapping) {
        log.debug("Request to save MetaStarMapping : {}", metaStarMapping);
        return metaStarMappingRepository.save(metaStarMapping);
    }

    /**
     * Update a metaStarMapping.
     *
     * @param metaStarMapping the entity to save.
     * @return the persisted entity.
     */
    public MetaStarMapping update(MetaStarMapping metaStarMapping) {
        log.debug("Request to update MetaStarMapping : {}", metaStarMapping);
        metaStarMapping.setIsPersisted();
        return metaStarMappingRepository.save(metaStarMapping);
    }

    /**
     * Partially update a metaStarMapping.
     *
     * @param metaStarMapping the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaStarMapping> partialUpdate(MetaStarMapping metaStarMapping) {
        log.debug("Request to partially update MetaStarMapping : {}", metaStarMapping);

        return metaStarMappingRepository
            .findById(metaStarMapping.getId())
            .map(existingMetaStarMapping -> {
                if (metaStarMapping.getName() != null) {
                    existingMetaStarMapping.setName(metaStarMapping.getName());
                }
                if (metaStarMapping.getEntityId() != null) {
                    existingMetaStarMapping.setEntityId(metaStarMapping.getEntityId());
                }
                if (metaStarMapping.getDefinition() != null) {
                    existingMetaStarMapping.setDefinition(metaStarMapping.getDefinition());
                }
                if (metaStarMapping.getCreatedBy() != null) {
                    existingMetaStarMapping.setCreatedBy(metaStarMapping.getCreatedBy());
                }
                if (metaStarMapping.getCreatedTs() != null) {
                    existingMetaStarMapping.setCreatedTs(metaStarMapping.getCreatedTs());
                }
                if (metaStarMapping.getUpdatedBy() != null) {
                    existingMetaStarMapping.setUpdatedBy(metaStarMapping.getUpdatedBy());
                }
                if (metaStarMapping.getUpdatedTs() != null) {
                    existingMetaStarMapping.setUpdatedTs(metaStarMapping.getUpdatedTs());
                }

                return existingMetaStarMapping;
            })
            .map(metaStarMappingRepository::save);
    }

    /**
     * Get all the metaStarMappings.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MetaStarMapping> findAll() {
        log.debug("Request to get all MetaStarMappings");
        return metaStarMappingRepository.findAll();
    }

    /**
     * Get one metaStarMapping by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaStarMapping> findOne(String id) {
        log.debug("Request to get MetaStarMapping : {}", id);
        return metaStarMappingRepository.findById(id);
    }

    /**
     * Delete the metaStarMapping by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete MetaStarMapping : {}", id);
        metaStarMappingRepository.deleteById(id);
    }
}

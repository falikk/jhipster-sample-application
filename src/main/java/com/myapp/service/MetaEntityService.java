package com.myapp.service;

import com.myapp.domain.MetaEntity;
import com.myapp.repository.MetaEntityRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MetaEntity}.
 */
@Service
@Transactional
public class MetaEntityService {

    private final Logger log = LoggerFactory.getLogger(MetaEntityService.class);

    private final MetaEntityRepository metaEntityRepository;

    public MetaEntityService(MetaEntityRepository metaEntityRepository) {
        this.metaEntityRepository = metaEntityRepository;
    }

    /**
     * Save a metaEntity.
     *
     * @param metaEntity the entity to save.
     * @return the persisted entity.
     */
    public MetaEntity save(MetaEntity metaEntity) {
        log.debug("Request to save MetaEntity : {}", metaEntity);
        return metaEntityRepository.save(metaEntity);
    }

    /**
     * Update a metaEntity.
     *
     * @param metaEntity the entity to save.
     * @return the persisted entity.
     */
    public MetaEntity update(MetaEntity metaEntity) {
        log.debug("Request to update MetaEntity : {}", metaEntity);
        metaEntity.setIsPersisted();
        return metaEntityRepository.save(metaEntity);
    }

    /**
     * Partially update a metaEntity.
     *
     * @param metaEntity the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaEntity> partialUpdate(MetaEntity metaEntity) {
        log.debug("Request to partially update MetaEntity : {}", metaEntity);

        return metaEntityRepository
            .findById(metaEntity.getId())
            .map(existingMetaEntity -> {
                if (metaEntity.getName() != null) {
                    existingMetaEntity.setName(metaEntity.getName());
                }
                if (metaEntity.getDescription() != null) {
                    existingMetaEntity.setDescription(metaEntity.getDescription());
                }
                if (metaEntity.getDefinition() != null) {
                    existingMetaEntity.setDefinition(metaEntity.getDefinition());
                }
                if (metaEntity.getCreatedBy() != null) {
                    existingMetaEntity.setCreatedBy(metaEntity.getCreatedBy());
                }
                if (metaEntity.getCreatedTs() != null) {
                    existingMetaEntity.setCreatedTs(metaEntity.getCreatedTs());
                }
                if (metaEntity.getUpdatedBy() != null) {
                    existingMetaEntity.setUpdatedBy(metaEntity.getUpdatedBy());
                }
                if (metaEntity.getUpdatedTs() != null) {
                    existingMetaEntity.setUpdatedTs(metaEntity.getUpdatedTs());
                }

                return existingMetaEntity;
            })
            .map(metaEntityRepository::save);
    }

    /**
     * Get all the metaEntities.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MetaEntity> findAll() {
        log.debug("Request to get all MetaEntities");
        return metaEntityRepository.findAll();
    }

    /**
     * Get one metaEntity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaEntity> findOne(String id) {
        log.debug("Request to get MetaEntity : {}", id);
        return metaEntityRepository.findById(id);
    }

    /**
     * Delete the metaEntity by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete MetaEntity : {}", id);
        metaEntityRepository.deleteById(id);
    }
}

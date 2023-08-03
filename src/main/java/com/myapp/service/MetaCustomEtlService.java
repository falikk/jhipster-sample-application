package com.myapp.service;

import com.myapp.domain.MetaCustomEtl;
import com.myapp.repository.MetaCustomEtlRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MetaCustomEtl}.
 */
@Service
@Transactional
public class MetaCustomEtlService {

    private final Logger log = LoggerFactory.getLogger(MetaCustomEtlService.class);

    private final MetaCustomEtlRepository metaCustomEtlRepository;

    public MetaCustomEtlService(MetaCustomEtlRepository metaCustomEtlRepository) {
        this.metaCustomEtlRepository = metaCustomEtlRepository;
    }

    /**
     * Save a metaCustomEtl.
     *
     * @param metaCustomEtl the entity to save.
     * @return the persisted entity.
     */
    public MetaCustomEtl save(MetaCustomEtl metaCustomEtl) {
        log.debug("Request to save MetaCustomEtl : {}", metaCustomEtl);
        return metaCustomEtlRepository.save(metaCustomEtl);
    }

    /**
     * Update a metaCustomEtl.
     *
     * @param metaCustomEtl the entity to save.
     * @return the persisted entity.
     */
    public MetaCustomEtl update(MetaCustomEtl metaCustomEtl) {
        log.debug("Request to update MetaCustomEtl : {}", metaCustomEtl);
        metaCustomEtl.setIsPersisted();
        return metaCustomEtlRepository.save(metaCustomEtl);
    }

    /**
     * Partially update a metaCustomEtl.
     *
     * @param metaCustomEtl the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaCustomEtl> partialUpdate(MetaCustomEtl metaCustomEtl) {
        log.debug("Request to partially update MetaCustomEtl : {}", metaCustomEtl);

        return metaCustomEtlRepository
            .findById(metaCustomEtl.getId())
            .map(existingMetaCustomEtl -> {
                if (metaCustomEtl.getName() != null) {
                    existingMetaCustomEtl.setName(metaCustomEtl.getName());
                }
                if (metaCustomEtl.getSqlStatement() != null) {
                    existingMetaCustomEtl.setSqlStatement(metaCustomEtl.getSqlStatement());
                }
                if (metaCustomEtl.getCreatedBy() != null) {
                    existingMetaCustomEtl.setCreatedBy(metaCustomEtl.getCreatedBy());
                }
                if (metaCustomEtl.getCreatedTs() != null) {
                    existingMetaCustomEtl.setCreatedTs(metaCustomEtl.getCreatedTs());
                }
                if (metaCustomEtl.getUpdatedBy() != null) {
                    existingMetaCustomEtl.setUpdatedBy(metaCustomEtl.getUpdatedBy());
                }
                if (metaCustomEtl.getUpdatedTs() != null) {
                    existingMetaCustomEtl.setUpdatedTs(metaCustomEtl.getUpdatedTs());
                }

                return existingMetaCustomEtl;
            })
            .map(metaCustomEtlRepository::save);
    }

    /**
     * Get all the metaCustomEtls.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MetaCustomEtl> findAll() {
        log.debug("Request to get all MetaCustomEtls");
        return metaCustomEtlRepository.findAll();
    }

    /**
     * Get one metaCustomEtl by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaCustomEtl> findOne(String id) {
        log.debug("Request to get MetaCustomEtl : {}", id);
        return metaCustomEtlRepository.findById(id);
    }

    /**
     * Delete the metaCustomEtl by id.
     *
     * @param id the id of the entity.
     */
    public void delete(String id) {
        log.debug("Request to delete MetaCustomEtl : {}", id);
        metaCustomEtlRepository.deleteById(id);
    }
}

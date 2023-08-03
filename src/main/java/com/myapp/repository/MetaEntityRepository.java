package com.myapp.repository;

import com.myapp.domain.MetaEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MetaEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MetaEntityRepository extends JpaRepository<MetaEntity, String> {}

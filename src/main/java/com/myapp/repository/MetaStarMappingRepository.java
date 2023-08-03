package com.myapp.repository;

import com.myapp.domain.MetaStarMapping;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MetaStarMapping entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MetaStarMappingRepository extends JpaRepository<MetaStarMapping, String> {}

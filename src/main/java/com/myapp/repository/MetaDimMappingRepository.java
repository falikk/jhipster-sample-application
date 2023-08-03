package com.myapp.repository;

import com.myapp.domain.MetaDimMapping;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MetaDimMapping entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MetaDimMappingRepository extends JpaRepository<MetaDimMapping, String> {}

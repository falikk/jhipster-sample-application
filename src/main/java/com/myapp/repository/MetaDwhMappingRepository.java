package com.myapp.repository;

import com.myapp.domain.MetaDwhMapping;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MetaDwhMapping entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MetaDwhMappingRepository extends JpaRepository<MetaDwhMapping, String> {}

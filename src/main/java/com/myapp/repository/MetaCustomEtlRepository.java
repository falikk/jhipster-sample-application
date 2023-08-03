package com.myapp.repository;

import com.myapp.domain.MetaCustomEtl;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MetaCustomEtl entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MetaCustomEtlRepository extends JpaRepository<MetaCustomEtl, String> {}

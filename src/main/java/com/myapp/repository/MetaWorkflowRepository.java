package com.myapp.repository;

import com.myapp.domain.MetaWorkflow;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MetaWorkflow entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MetaWorkflowRepository extends JpaRepository<MetaWorkflow, String> {}

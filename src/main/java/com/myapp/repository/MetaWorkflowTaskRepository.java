package com.myapp.repository;

import com.myapp.domain.MetaWorkflowTask;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the MetaWorkflowTask entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MetaWorkflowTaskRepository extends JpaRepository<MetaWorkflowTask, String> {}

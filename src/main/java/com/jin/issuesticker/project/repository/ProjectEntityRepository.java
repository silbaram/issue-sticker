package com.jin.issuesticker.project.repository;

import com.jin.issuesticker.project.models.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Long> {
    Long countByProjectCode(String projectCode);
}

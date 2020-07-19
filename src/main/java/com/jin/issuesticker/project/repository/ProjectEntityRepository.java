package com.jin.issuesticker.project.repository;

import com.jin.issuesticker.project.models.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Long> {
    Long countByProjectCode(String projectCode);

    @Query("select p from ProjectEntity p inner join p.userToProjectEntityList up where up.userIdx = :userIdx")
    List<ProjectEntity> findByUserIdx(Long userIdx);

    ProjectEntity findByProjectCode(String projectCode);
}

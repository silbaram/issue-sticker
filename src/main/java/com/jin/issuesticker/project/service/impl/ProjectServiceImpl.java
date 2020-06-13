package com.jin.issuesticker.project.service.impl;

import com.jin.issuesticker.project.dto.ProjectDto;
import com.jin.issuesticker.project.models.ProjectEntity;
import com.jin.issuesticker.project.repository.ProjectEntityRepository;
import com.jin.issuesticker.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectEntityRepository projectEntityRepository;


    /**
     * 프로젝트 생성
     * @param monoProjectDto
     * @return
     */
    @Override
    public boolean saveProject(Mono<ProjectDto> monoProjectDto) {
        ProjectDto projectDto = monoProjectDto.block();

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectCode(projectDto.getCode());
        projectEntity.setTitle(projectDto.getTitle());
        projectEntity.setDescription(projectDto.getDescription());
        projectEntity.setRegisteredDate(Timestamp.valueOf(LocalDateTime.now()));

        try {
            projectEntityRepository.save(projectEntity);

            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 프로젝트 생성시 프로젝트 코드 중복 체크
     * @param projectCode
     * @return
     */
    @Override
    public boolean checkProjectCode(String projectCode) {
        Long count = projectEntityRepository.countByProjectCode(projectCode);

        return count > 0 ? false : true;
    }
}

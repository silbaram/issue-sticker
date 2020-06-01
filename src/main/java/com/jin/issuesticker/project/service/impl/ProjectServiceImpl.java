package com.jin.issuesticker.project.service.impl;

import com.jin.issuesticker.project.dto.ProjectDto;
import com.jin.issuesticker.project.models.ProjectEntity;
import com.jin.issuesticker.project.repository.ProjectEntityRepository;
import com.jin.issuesticker.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


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
        projectEntity.setKey(projectDto.getKey());
        projectEntity.setTitle(projectDto.getTitle());
        projectEntity.setDescription(projectDto.getDescription());

        try {
            projectEntityRepository.save(projectEntity);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

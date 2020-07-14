package com.jin.issuesticker.project.service;

import com.jin.issuesticker.project.dto.ProjectDto;
import com.jin.issuesticker.project.models.ProjectEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {
    boolean saveProject(Mono<ProjectDto> projectDto);
    boolean checkProjectCode(String projectCode);
    Flux<ProjectDto> findByUserIdx(Long userIdx);
}

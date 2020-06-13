package com.jin.issuesticker.project.service;

import com.jin.issuesticker.project.dto.ProjectDto;
import reactor.core.publisher.Mono;

public interface ProjectService {
    boolean saveProject(Mono<ProjectDto> projectDto);
    boolean checkProjectCode(String projectCode);
}

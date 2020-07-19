package com.jin.issuesticker.project.service;

import com.jin.issuesticker.project.dto.ProjectDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {

    /**
     * 프로젝트 생성
     * @param projectDto
     * @return
     */
    boolean saveProject(Mono<ProjectDto> projectDto);

    /**
     * 프로젝트 생성시 프로젝트 코드 중복 체크
     * @param projectCode
     * @return
     */
    boolean checkProjectCode(String projectCode);

    /**
     * 사용자 별 프로젝트 검색
     * @param userIdx
     * @return
     */
    Flux<ProjectDto> findByUserIdx(Long userIdx);

    /**
     * 프로젝트 상세 내용 조회
     * @param code
     * @return
     */
    Mono<ProjectDto> findProjectDetail(String code);
}

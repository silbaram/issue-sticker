package com.jin.issuesticker.project.handler;

import com.jin.issuesticker.project.dto.ProjectDto;
import com.jin.issuesticker.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;


@Component
public class ProjectHandlerFunctional {

    @Autowired
    ProjectService projectService;


    /**
     * 사용자 별 프로젝트 검색
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> findUserInProjects(ServerRequest serverRequest) {
        Principal principal = (Principal) serverRequest.principal();

        return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue("검색 조건을 확인 해주세요.");
    }


    /**
     * 프로젝트 생성
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> saveProjectHandler(ServerRequest serverRequest) {
        Mono<ProjectDto> projectDtoMono = serverRequest.bodyToMono(ProjectDto.class);

        boolean saveResult = projectService.saveProject(projectDtoMono);

        if (saveResult) {
            return ServerResponse.ok().body(BodyInserters.fromValue("success"));
        } else {
            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BodyInserters.fromValue("error"));
        }
    }


    /**
     * 프로젝트 생성시 프로젝트 코드 중복 체크
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> uniqueCodeValidationHandler(ServerRequest serverRequest) {
        String checkCode = serverRequest.pathVariable("code");

        boolean checkResult = projectService.checkProjectCode(checkCode);

        if (checkResult) {
            return ServerResponse.ok().body(BodyInserters.fromValue("success"));
        } else {
            return ServerResponse.ok().body(BodyInserters.fromValue("error"));
        }
    }
}

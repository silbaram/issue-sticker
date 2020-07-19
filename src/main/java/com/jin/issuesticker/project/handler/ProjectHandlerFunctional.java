package com.jin.issuesticker.project.handler;

import com.jin.issuesticker.project.dto.ProjectDto;
import com.jin.issuesticker.project.models.ProjectEntity;
import com.jin.issuesticker.project.service.ProjectService;
import com.jin.issuesticker.security.auth.JWTUtil;
import com.jin.issuesticker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class ProjectHandlerFunctional {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    private JWTUtil jwtUtil;


    /**
     * 사용자 별 프로젝트 검색
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> findUserInProjects(ServerRequest serverRequest) {

        List<String> authToken = serverRequest.headers().header(HttpHeaders.AUTHORIZATION);
        String userIdx = jwtUtil.getUserIdxFromToken(authToken.get(0).substring(7));

        if (StringUtils.isEmpty(userIdx)) {
            return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue("검색 조건을 확인 해주세요.");
        } else {
            Flux<ProjectDto> ProjectDtoFlux = projectService.findByUserIdx(Long.valueOf(userIdx));
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(ProjectDtoFlux, ProjectEntity.class);
        }
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


    /**
     * 프로젝트 상세 내용 조회
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> findProjectDetailHandler(ServerRequest serverRequest) {
        String projectCode = serverRequest.pathVariable("code");

        Mono<ProjectDto> projectDtoMono = projectService.findProjectDetail(projectCode);

        return ServerResponse.ok().body(projectDtoMono, ProjectDto.class);
    }
}

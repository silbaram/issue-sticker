package com.jin.issuesticker.project.router;

import com.jin.issuesticker.project.handler.ProjectHandlerFunctional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Component
public class ProjectRouterFunctional {


    /**
     * 프로젝트 생성
     * @param projectHandlerFunctional
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> saveProjectRouter(ProjectHandlerFunctional projectHandlerFunctional) {

        return RouterFunctions.route(POST("/project").and(accept(APPLICATION_JSON)), projectHandlerFunctional::saveProjectHandler);
    }


    /**
     * 프로젝트 생성시 프로젝트 코드 중복 체크
     * @param projectHandlerFunctional
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> uniqueCodeValidation(ProjectHandlerFunctional projectHandlerFunctional) {

        return RouterFunctions.route(GET("/project/validation/{code}"), projectHandlerFunctional::uniqueCodeValidation);
    }
}

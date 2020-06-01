package com.jin.issuesticker.security.router;

import com.jin.issuesticker.security.handler.JoinHandlerFunctional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Component
public class JoinRouterFunctional {


    /**
     * 회원 가입 요청
     * @param joinHandlerFunctional
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> saveJoinRouter(JoinHandlerFunctional joinHandlerFunctional) {

        return RouterFunctions.route(POST("/security/join").and(accept(APPLICATION_JSON)), joinHandlerFunctional::saveJoinHandler);
    }


    /**
     * 회원 가입시 아이디 중복이 있는지 체크
     * @param joinHandlerFunctional
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> uniqueIdValidation(JoinHandlerFunctional joinHandlerFunctional) {

        return RouterFunctions.route(GET("/security/validation/{id}"), joinHandlerFunctional::uniqueIdValidation);
    }
}

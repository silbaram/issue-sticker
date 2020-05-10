package com.jin.issuesticker.security.router;

import com.jin.issuesticker.security.handler.JoinHandlerFunctional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class JoinRouterFunctional {


    /**
     * 회원로그인, 가입 등 root 화면
     * @param html
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> loginHtmlRouter(@Value("classpath:/public/index.html") Resource html) {

        return RouterFunctions.route(GET("/security/login"), request
                -> ok().contentType(MediaType.TEXT_HTML).bodyValue(html));
    }


    /**
     * 회원 가입 요청
     * @param joinHandlerFunctional
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> saveJoinRouter(JoinHandlerFunctional joinHandlerFunctional) {

        return RouterFunctions.route(POST("/security/join").and(accept(APPLICATION_JSON)), joinHandlerFunctional::join);
    }
}

package com.jin.issuesticker.security.router;

import com.jin.issuesticker.security.handler.JoinHandlerFunctional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class JoinRouterFunctional {


    @Bean
    public RouterFunction<ServerResponse> joinRouter(@Value("classpath:/public/index.html") Resource html) {
        return RouterFunctions.route(GET("/join"), request
                -> ok().contentType(MediaType.TEXT_HTML).bodyValue(html));
    }

    @Bean
    public RouterFunction<ServerResponse> saveJoinRouter(JoinHandlerFunctional joinHandlerFunctional) {

        return RouterFunctions.route(POST("/security/join").and(accept(APPLICATION_JSON)), joinHandlerFunctional::join);
    }
}

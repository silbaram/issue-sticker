package com.jin.issuesticker.security.router;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;


@Component
@RequestMapping("/security")
public class JoinRouterFunctional {


//    @Bean
//    public RouterFunction<ServerResponse> joinRouter() {
//        return RouterFunctions.route(POST("/join"), null); //TODO handlerFunction 작성해야됨
//    }
}

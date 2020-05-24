package com.jin.issuesticker.home.router;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;


@Component
public class IndexRouterFunctional {


    @Bean
    public RouterFunction<ServerResponse> indexRouter() {
        return RouterFunctions.route(GET("/"), request
                -> ServerResponse.temporaryRedirect(URI.create("/security/login")).build()); //TODO 로그인 유무에 따라서 redirect 하는 url을 변경해줘야함
    }
}

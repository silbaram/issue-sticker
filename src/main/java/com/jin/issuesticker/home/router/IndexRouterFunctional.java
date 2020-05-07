package com.jin.issuesticker.home.router;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class IndexRouterFunctional {


    @Bean
    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:/public/index.html") Resource html) {
        return RouterFunctions.route(GET("/"), request
                -> ok().contentType(MediaType.TEXT_HTML).bodyValue(html));
    }
}

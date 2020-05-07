package com.jin.issuesticker.security.handler;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class JoinHandlerFunctional {


    @JsonValue
    public Mono<ServerResponse> joinHtml(ServerRequest serverRequest) {
        return ServerResponse.ok().render("index", "login");
    }
}

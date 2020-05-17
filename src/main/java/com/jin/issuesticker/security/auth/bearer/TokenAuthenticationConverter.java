package com.jin.issuesticker.security.auth.bearer;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.Authenticator;
import java.util.function.Function;


public class TokenAuthenticationConverter {

    private static final String BEARER = "Bearer ";


    private Function<ServerWebExchange, Mono<Authenticator>> tokenAuthenticationConverter() {
        return serverWebExchange -> {
            String authorization = serverWebExchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (authorization != null && !authorization.startsWith(BEARER)) {
                return Mono.empty();
            }

            return Mono.just(null); //TODO 토큰 정리흐는 부분 추가 해야됨
        };
    }
}

package com.jin.issuesticker.security.handler;

import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class JoinHandlerFunctional {

    @Autowired
    private UserService userService;


    /**
     * 회원 가입 처리
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> saveJoinHandler(ServerRequest serverRequest) {

        Mono<JoinUserDto> joinUserDtoMono = serverRequest.bodyToMono(JoinUserDto.class);

        JoinUserDto saveUserDto = userService.saveUser(joinUserDtoMono);

        if(saveUserDto.isResult()) {
            return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(saveUserDto), JoinUserDto.class);
        } else {
            return ServerResponse.badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(saveUserDto), JoinUserDto.class);
        }

    }


    /**
     * 회원 가입시 ID 중복 체크 처리
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> uniqueIdValidationHandler(ServerRequest serverRequest) {

        String checkId = serverRequest.pathVariable("id");

        boolean checkResult = userService.joinCheckId(checkId);

        if (checkResult) {
            return ServerResponse.ok().body(BodyInserters.fromValue("success"));
        } else {
            return ServerResponse.ok().body(BodyInserters.fromValue("error"));
        }
    }
}

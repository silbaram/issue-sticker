package com.jin.issuesticker.security.handler;

import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Component
public class JoinHandlerFunctional {

    @Autowired
    UserService userService;


    /**
     * 회원 가입 처리
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> join(ServerRequest serverRequest) {

        Mono<JoinUserDto> userDto = serverRequest.bodyToMono(JoinUserDto.class);

        JoinUserDto saveUserDto = userService.saveUserInfo(userDto);

        if(saveUserDto.isResult()) {
            return ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(userDto, JoinUserDto.class);
        } else {
            return ServerResponse.badRequest()
                    .contentType(APPLICATION_JSON)
                    .body(userDto, JoinUserDto.class);
        }

    }


    /**
     * 회원 가입시 ID 중복 체크 처리
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> uniqueIdValidation(ServerRequest serverRequest) {

        String checkId = serverRequest.pathVariable("id");

        boolean checkResult = userService.joinCheckId(checkId);

        if(checkResult) {
            return ServerResponse.ok().body(BodyInserters.fromValue("success"));
        } else {
            return ServerResponse.ok().body(BodyInserters.fromValue("error"));
        }
    }
}

package com.jin.issuesticker.security.handler;

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

    public Mono<ServerResponse> join(ServerRequest serverRequest) {

        Mono<UserDto> userDto = serverRequest.bodyToMono(UserDto.class);

        UserDto saveUserDto = userService.saveUserInfo(userDto);

        if(saveUserDto.isResult()) {
            return ServerResponse.ok()
                    .contentType(APPLICATION_JSON)
                    .body(userDto, UserDto.class);
        } else {
            return ServerResponse.badRequest()
                    .contentType(APPLICATION_JSON)
                    .body(userDto, UserDto.class);
        }

    }

    public Mono<ServerResponse> checkId(ServerRequest serverRequest) {

        String checkId = serverRequest.pathVariable("id");

//        UserDto saveUserDto = userService.saveUserInfo(userDto);

//        if(saveUserDto.isResult()) {
//            return ServerResponse.ok()
//                    .contentType(APPLICATION_JSON)
//                    .body(userDto, UserDto.class);
//        } else {
//            return ServerResponse.badRequest()
//                    .contentType(APPLICATION_JSON)
//                    .body(userDto, UserDto.class);
//        }
//success

        return ServerResponse.ok().body(BodyInserters.fromValue("error"));
    }
}

package com.jin.issuesticker.security.handler;

import com.jin.issuesticker.security.auth.JWTUtil;
import com.jin.issuesticker.security.auth.PBKDF2Encoder;
import com.jin.issuesticker.security.auth.dto.AuthResponse;
import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Component
public class LoginHandlerFunctional {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PBKDF2Encoder passwordEncoder;

    @Autowired
    UserService userService;


    /**
     * 회원 로그인 처리
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> login(ServerRequest serverRequest) {

        Mono<UserDto> userDto = serverRequest.bodyToMono(UserDto.class);
        UserDto requestUserDto = userDto.block();
        Mono<UserDto> loginUserDto = userService.findById(requestUserDto.getId());

        UserDto checkLUserDto = loginUserDto.block();
        if (passwordEncoder.matches(requestUserDto.getPassword(), checkLUserDto.getPassword())) {
            return ServerResponse.ok().contentType(APPLICATION_JSON).body(new AuthResponse(jwtUtil.generateToken(checkLUserDto)), AuthResponse.class);
        } else {
            return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
        }
//        Mono<ServerResponse> serverResponseMono = loginUserDto.flatMap(userDetails -> {
//            if (passwordEncoder.encode(userDto.block().getPassword()).equals(userDetails.getPassword())) {
//                return ServerResponse.ok().contentType(APPLICATION_JSON).body(new AuthResponse(jwtUtil.generateToken(userDetails)), AuthResponse.class);
//            } else {
//                return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
//            }
//        }).defaultIfEmpty((ServerResponse) ServerResponse.status(HttpStatus.UNAUTHORIZED).build());

//        return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
    }
}

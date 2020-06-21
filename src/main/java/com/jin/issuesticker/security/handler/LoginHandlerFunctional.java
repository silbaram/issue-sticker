package com.jin.issuesticker.security.handler;

import com.jin.issuesticker.security.auth.JWTUtil;
import com.jin.issuesticker.security.auth.PBKDF2Encoder;
import com.jin.issuesticker.security.auth.dto.AuthResponse;
import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
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
    private UserService userService;


    /**
     * 회원 로그인 처리
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> loginHandler(ServerRequest serverRequest) {

        UserDto requestUserDto = serverRequest.bodyToMono(UserDto.class).block();

        // 회원 정보 조회
        Mono<UserDto> loginUserDto = userService.findByIdAndIsAccess(requestUserDto.getId());
        if (ObjectUtils.isEmpty(loginUserDto)) {
            return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
        }

        return loginUserDto.flatMap(userDetails -> {
            if (passwordEncoder.encode(requestUserDto.getPassword()).equals(userDetails.getPassword())) {
                return ServerResponse.ok().contentType(APPLICATION_JSON).body(Mono.just(new AuthResponse(jwtUtil.generateToken(userDetails))), AuthResponse.class);
            } else {
                return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
            }
        });
    }
}

package com.jin.issuesticker.user.handler;

import com.jin.issuesticker.user.dto.ProjectInUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Component
public class UserHandlerFunctional {

    @Autowired
    private UserService userService;


    /**
     * 프로젝트 접근 권한 관리를 위한 사용자 검색
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> findProjectInUsersHandler(ServerRequest serverRequest) {

        Optional<String> selectValue = serverRequest.queryParam("value");

        if (selectValue.isPresent()) {
            Flux<ProjectInUserDto> projectInUserDtoFlux = userService.findByIdLikeOrUsernameLike(selectValue.get(), selectValue.get());
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(projectInUserDtoFlux, ProjectInUserDto.class);
        } else {
            return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue("검색 조건을 확인 해주세요.");
        }

    }
}

package com.jin.issuesticker.user.router;

import com.jin.issuesticker.user.handler.UserHandlerFunctional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;


@Component
public class UserRouterFunctional {


    /**
     * 프로젝트 접근 권한 관리를 위한 사용자 검색
     * @param userHandlerFunctional
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> projectInUsersRouter(UserHandlerFunctional userHandlerFunctional) {

        return RouterFunctions.route(GET("/project/users"), userHandlerFunctional::findProjectInUsersHandler);
    }
}

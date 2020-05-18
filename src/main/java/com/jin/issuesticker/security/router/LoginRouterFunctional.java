package com.jin.issuesticker.security.router;

import com.jin.issuesticker.security.handler.LoginHandlerFunctional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class LoginRouterFunctional {


    /**
     * 회원로그인, 가입 등 root 화면
     * @param html
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> loginHtmlRouter(@Value("classpath:/public/index.html") Resource html) {

        return RouterFunctions.route(GET("/security/login"), request
                -> ok().contentType(MediaType.TEXT_HTML).bodyValue(html));
    }


    @Bean
    public RouterFunction<ServerResponse> loginRouter(LoginHandlerFunctional loginHandlerFunctional) {
        return RouterFunctions.route(POST("/security/login"), loginHandlerFunctional::login);
    }
}

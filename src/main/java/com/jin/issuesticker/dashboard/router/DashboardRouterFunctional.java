package com.jin.issuesticker.dashboard.router;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component
public class DashboardRouterFunctional {


    /**
     * 개인 이슈 사항 대시보드 페이지
     * @param html
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> personalDashboardRouterHtml(@Value("classpath:/public/index.html") Resource html) {
        return RouterFunctions.route(GET("/dashboard/personal"), request
                -> ok().contentType(MediaType.TEXT_HTML).bodyValue(html));
    }
}

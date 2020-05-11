package com.jin.issuesticker.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@WebFluxTest
@ActiveProfiles("local-front-build")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SecurityTest {

    @Autowired
    private WebTestClient webClient;


    @Test
    public void 아이디_체크_route_테스트() {
        webClient.get().uri("/security/check/test").exchange().expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED); //TODO UNAUTHORIZED인 이유는 찾아보자
    }


}

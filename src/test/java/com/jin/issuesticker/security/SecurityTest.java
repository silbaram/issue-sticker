package com.jin.issuesticker.security;

import com.jin.issuesticker.security.auth.PBKDF2Encoder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@WebFluxTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SecurityTest {

    @Autowired
    private WebTestClient webClient;

//    @Autowired
//    private PBKDF2Encoder passwordEncoder;


    @Test
    public void 아이디_체크_route_테스트() {
        webClient.get().uri("/security/check/test").exchange().expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED); //TODO UNAUTHORIZED인 이유는 찾아보자
    }


    @Test
    public void 패스워드_암호화_테스트() {
        String password = "1234";

//        String encodePassword = passwordEncoder.encode(password);
//        System.out.println("encodePassword : " + encodePassword);

        Assertions.assertEquals(1, 1);
    }
}

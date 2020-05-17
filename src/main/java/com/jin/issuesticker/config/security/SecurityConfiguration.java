package com.jin.issuesticker.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import reactor.core.publisher.Mono;


@Configuration
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
@Slf4j
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {


        String[] resources = new String[] {
            "/resources/**", "/public/**", "/static/**"
        };

        http
        .authorizeExchange()
        .pathMatchers(resources).permitAll()
        .pathMatchers("/security/**").permitAll()
        .anyExchange().authenticated()

        .and()
        .formLogin()
        .loginPage("/security/login")
        .authenticationFailureHandler((webFilterExchange, e) -> Mono.error(e))
        .authenticationSuccessHandler(new WebFilterChainServerAuthenticationSuccessHandler())

        .and()
        // 로그인 실패시 로그인 페이지로 redirect 가 아닌 실패 응답 (REST API를 사용하기 위함)
        .exceptionHandling()
        .authenticationEntryPoint((serverWebExchange, e) -> Mono.error(e))
        .accessDeniedHandler((serverWebExchange, e) -> Mono.error(e))

        .and()
        .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())

        .csrf(csrf -> csrf.disable())
        .logout(logoutSpec -> logoutSpec.disable());
        //.and()
        //.redirectToHttps(redirect -> redirect.httpsRedirectWhen(e -> e.getRequest().getHeaders().containsKey("X-Forwarded-Proto"));

        return http.build();
    }
}

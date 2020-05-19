package com.jin.issuesticker.config.security;

import com.jin.issuesticker.security.auth.AuthenticationManager;
import com.jin.issuesticker.security.auth.SecurityContextRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import reactor.core.publisher.Mono;


@Configuration
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
@Slf4j
public class SecurityConfiguration {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityContextRepository securityContextRepository;


    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {

        String[] resources = new String[] {
            "/resources/**", "/public/**", "/static/**"
        };

        http
        .csrf(csrf -> csrf.disable())
        .logout(logoutSpec -> logoutSpec.disable())
        .httpBasic(httpBasicSpec -> httpBasicSpec.disable());

        http
        .authenticationManager(authenticationManager)
        .securityContextRepository(securityContextRepository)
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
        // 로그인 실패, 권한이 없을시 특정페이지로 redirect 가 아닌 실패 응답 (REST API를 사용하기 위함)
        .exceptionHandling()
        .authenticationEntryPoint((serverWebExchange, e) -> Mono.error(e))
        .accessDeniedHandler((serverWebExchange, e) -> Mono.error(e))
        //.authenticationEntryPoint((serverWebExchange, e) -> Mono.fromRunnable((() -> serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED))))
        //.accessDeniedHandler((serverWebExchange, e) -> Mono.fromRunnable((() -> serverWebExchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN))))

//        .and()
//        .securityContextRepository(NoOpServerSecurityContextRepository.getInstance());
        //.and()
        //.redirectToHttps(redirect -> redirect.httpsRedirectWhen(e -> e.getRequest().getHeaders().containsKey("X-Forwarded-Proto"));
        ;
        return http.build();
    }
}

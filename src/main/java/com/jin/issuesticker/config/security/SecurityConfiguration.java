package com.jin.issuesticker.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.HeaderWriterServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.ServerLogoutHandler;
import org.springframework.security.web.server.header.ClearSiteDataServerHttpHeadersWriter;

import static org.springframework.security.web.server.header.ClearSiteDataServerHttpHeadersWriter.Directive.CACHE;
import static org.springframework.security.web.server.header.ClearSiteDataServerHttpHeadersWriter.Directive.COOKIES;


@Configuration
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
@Slf4j
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {

        ServerLogoutHandler securityContext = new SecurityContextServerLogoutHandler();
        ClearSiteDataServerHttpHeadersWriter writer = new ClearSiteDataServerHttpHeadersWriter(CACHE, COOKIES);
        ServerLogoutHandler clearSiteData = new HeaderWriterServerLogoutHandler(writer);
        DelegatingServerLogoutHandler logoutHandler = new DelegatingServerLogoutHandler(securityContext, clearSiteData);

        String[] resources = new String[] {
            "/", "/resources/**", "/public/**", "/static/**"
        };

        http
        .csrf(csrf -> csrf.disable())
        .authorizeExchange()
        .pathMatchers(resources).permitAll()
        .pathMatchers("/join").permitAll()
        .anyExchange().authenticated()
        .and()
        .redirectToHttps(redirect -> redirect.httpsRedirectWhen(e -> e.getRequest().getHeaders().containsKey("X-Forwarded-Proto"))
        .and()
        .httpBasic()
        .and()
        .formLogin()
        .loginPage("/login")
        .and()
        .logout()
        .logoutHandler(logoutHandler));

        return http.build();
    }
}

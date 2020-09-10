package com.jin.issuesticker.security.auth;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    @Autowired
    private JWTUtil jwtUtil;


    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {

        String authToken = authentication.getCredentials().toString();
        if (!jwtUtil.validateToken(authToken)) {
            return Mono.empty();
        }

        try {
            // 토큰 유효기간 확인
            Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
            List<String> rolesMap = claims.get("role", List.class);
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (String roleMap : rolesMap) {
                authorities.add(new SimpleGrantedAuthority(roleMap));
            }

            return Mono.just(new UsernamePasswordAuthenticationToken(claims, null, authorities));

        } catch (Exception e) {
            return Mono.empty();
        }
    }
}

package com.jin.issuesticker.security.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    // TODO user Repository 추가


    @Override
    public Mono<UserDetails> findByUsername(String s) {

        // TODO user Repository 에서 사용자 검색 후 걸과 리턴

        return null;
    }
}

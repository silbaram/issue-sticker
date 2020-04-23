package com.jin.issuesticker.security.service;


import com.jin.issuesticker.user.models.UserEntity;
import com.jin.issuesticker.user.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    UserEntityRepository userEntityRepository;


    @Override
    public Mono<UserDetails> findByUsername(String s) throws UsernameNotFoundException {
        log.info("findByUsername : {}", s);
        //TODO UserDetails 객체를 생성후 Mono객체로 컴퍼트
        //UserEntity user = userEntityRepository.findById(id);

        //TODO 임시로 지정
        UserDetails user = User.builder()
        .username("user")
        .password("{noop}user")
        .roles("USER")
        .build();

        return Mono.just(user);
    }
}

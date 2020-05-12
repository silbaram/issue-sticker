package com.jin.issuesticker.security.service;

import com.jin.issuesticker.user.models.UserEntity;
import com.jin.issuesticker.user.repository.UserEntityRepository;
import com.sun.xml.bind.v2.model.core.ID;
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
    public Mono<UserDetails> findByUsername(String id) throws UsernameNotFoundException {

        UserEntity user = userEntityRepository.findById(id);

        //TODO 임시로 지정
        UserDetails userDetails = User.builder()
        .username(user.getName())
        .roles("USER")
        .build();

        return Mono.just(userDetails);
    }
}

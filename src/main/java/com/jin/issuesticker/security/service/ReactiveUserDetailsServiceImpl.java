package com.jin.issuesticker.security.service;

import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.models.UserEntity;
import com.jin.issuesticker.user.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Arrays;


@Component
@Slf4j
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    UserEntityRepository userEntityRepository;


    @Override
    public Mono<UserDetails> findByUsername(String id) throws UsernameNotFoundException {

        UserEntity user = userEntityRepository.findById(id);

        UserDto userDetails = UserDto.builder()
        .id(user.getId())
        .username(user.getUsername())
        .roles(Arrays.asList("ROLE_USER")) //TODO DB에서 값을 가져오도록 수정 해야됨
        .build();

        return Mono.just(userDetails);
    }
}

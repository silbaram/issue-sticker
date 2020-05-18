package com.jin.issuesticker.user.service;

import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import reactor.core.publisher.Mono;


public interface UserService {
    JoinUserDto saveUserInfo(Mono<JoinUserDto> userDto);
    boolean joinCheckId(String id);
    Mono<UserDto> findById(String id);
}

package com.jin.issuesticker.user.service;

import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import reactor.core.publisher.Mono;

import java.util.List;


public interface UserService {
    JoinUserDto saveUser(Mono<JoinUserDto> userDto);
    boolean joinCheckId(String id);
    Mono<UserDto> findByIdAndIsAccess(String id);
    List<UserDto> findByIdOrUsernameLike(String id, String username);
}

package com.jin.issuesticker.user.service;

import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.dto.ProjectInUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.models.UserEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface UserService {
    JoinUserDto saveUser(Mono<JoinUserDto> userDto);
    boolean joinCheckId(String id);
    Mono<UserDto> findByIdAndIsAccess(String id);
    Flux<ProjectInUserDto> findByIdLikeOrUsernameLike(String id, String username);
}

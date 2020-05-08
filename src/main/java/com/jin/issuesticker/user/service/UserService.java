package com.jin.issuesticker.user.service;

import com.jin.issuesticker.user.dto.UserDto;
import reactor.core.publisher.Mono;


public interface UserService {
    UserDto saveUserInfo(Mono<UserDto> userDto);
}

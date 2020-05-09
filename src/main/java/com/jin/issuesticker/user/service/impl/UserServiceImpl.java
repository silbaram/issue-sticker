package com.jin.issuesticker.user.service.impl;

import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.models.UserEntity;
import com.jin.issuesticker.user.repository.UserEntityRepository;
import com.jin.issuesticker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    /**
     * 사용자 정보를 DB에 등록
     * @param monoUserDto
     */
    @Override
    public UserDto saveUserInfo(Mono<UserDto> monoUserDto) {
        UserDto userDto = monoUserDto.block();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setRegisteredDate(Timestamp.valueOf(LocalDateTime.now()));

        try {
            userEntityRepository.save(userEntity);

            userDto.setResult(true);
        } catch (Exception e) {
            userDto.setResult(false);
        }

        return userDto;
    }
}

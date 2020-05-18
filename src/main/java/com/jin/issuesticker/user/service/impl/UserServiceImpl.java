package com.jin.issuesticker.user.service.impl;

import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.models.UserEntity;
import com.jin.issuesticker.user.repository.UserEntityRepository;
import com.jin.issuesticker.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    ModelMapper modelMapper;


    /**
     * 사용자 정보를 DB에 등록
     * @param monoUserDto
     */
    @Override
    public JoinUserDto saveUserInfo(Mono<JoinUserDto> monoUserDto) {
        JoinUserDto joinUserDto = monoUserDto.block();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(joinUserDto.getId());
        userEntity.setUsername(joinUserDto.getName());
        userEntity.setEmail(joinUserDto.getEmail());
        userEntity.setRegisteredDate(Timestamp.valueOf(LocalDateTime.now()));

        try {
            userEntityRepository.save(userEntity);

            joinUserDto.setResult(true);
        } catch (Exception e) {
            joinUserDto.setResult(false);
        }

        return joinUserDto;
    }


    /**
     * 회원 가입시 ID 중복 체크용
     * @param id
     * @return true: 사용가능, false: 중복
     */
    @Override
    public boolean joinCheckId(String id) {
        Long count = userEntityRepository.countById(id);
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 아이디로 유저 정보 찾기
     * @param id
     * @return
     */
    @Override
    public Mono<UserDto> findById(String id) {
        UserEntity userEntity = userEntityRepository.findById(id);
        UserDto userDto = modelMapper.map(userEntity, UserDto.class);

        return Mono.just(userDto);
    }
}

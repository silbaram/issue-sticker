package com.jin.issuesticker.user.service.impl;

import com.jin.issuesticker.security.auth.PBKDF2Encoder;
import com.jin.issuesticker.user.dto.JoinUserDto;
import com.jin.issuesticker.user.dto.ProjectInUserDto;
import com.jin.issuesticker.user.dto.UserDto;
import com.jin.issuesticker.user.models.UserEntity;
import com.jin.issuesticker.user.repository.UserEntityRepository;
import com.jin.issuesticker.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    private PBKDF2Encoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;


    /**
     * 사용자 정보를 DB에 등록
     * @param joinUserDtoMono
     */
    @Override
    public JoinUserDto saveUser(Mono<JoinUserDto> joinUserDtoMono) {
        JoinUserDto joinUserDto = joinUserDtoMono.block();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(joinUserDto.getId());
        userEntity.setUsername(joinUserDto.getName());
        userEntity.setPassword(passwordEncoder.encode(joinUserDto.getPassword()));
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

        return count > 0 ? false : true;
    }


    /**
     * 아이디로 유저 정보 찾기
     * @param id
     * @return
     */
    @Override
    public Mono<UserDto> findByIdAndIsAccess(String id) {
        UserEntity userEntity = userEntityRepository.findByIdAndIsAccess(id, 1);
        if (ObjectUtils.isEmpty(userEntity)) {
            return null;
        }

        List<String> roleList = new ArrayList<>();
        roleList.add("USER");
        UserDto userDto = UserDto.builder()
                .idx(userEntity.getIdx())
                .id(userEntity.getId())
                .password(userEntity.getPassword())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .isAccess(0)
                .roles(roleList)
                .build();

        return Mono.just(userDto);
    }


    /**
     * 아이디 또는 이름 으로 사용자 정보 검색
     * @param id
     * @param username
     * @return
     */
    @Override
    public Flux<ProjectInUserDto> findByIdContainingOrUsernameContaining(String id, String username) {
        List<UserEntity> userEntityList = userEntityRepository.findByIdContainingOrUsernameContaining(id, username);

        List<ProjectInUserDto> projectInUserDtoList = userEntityList.stream()
                .map(userEntityMono -> ProjectInUserDto.builder().idx(userEntityMono.getIdx()).username(userEntityMono.getUsername()).build())
                .collect(Collectors.toList());

        return Flux.fromIterable(projectInUserDtoList);
    }
}

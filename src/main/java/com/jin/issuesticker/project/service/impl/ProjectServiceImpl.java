package com.jin.issuesticker.project.service.impl;

import com.jin.issuesticker.common.models.UserToProjectEntity;
import com.jin.issuesticker.common.models.UserToProjectEntityPK;
import com.jin.issuesticker.common.repository.UserToProjectEntityRepository;
import com.jin.issuesticker.project.dto.ProjectDto;
import com.jin.issuesticker.project.models.ProjectEntity;
import com.jin.issuesticker.project.repository.ProjectEntityRepository;
import com.jin.issuesticker.project.service.ProjectService;
import com.jin.issuesticker.user.models.UserEntity;
import com.jin.issuesticker.user.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectEntityRepository projectEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private UserToProjectEntityRepository userToProjectEntityRepository;


    /**
     * 프로젝트 생성
     * @param monoProjectDto
     * @return
     */
    @Override
    @Transactional
    public boolean saveProject(Mono<ProjectDto> monoProjectDto) {
        ProjectDto projectDto = monoProjectDto.block();

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectCode(projectDto.getCode());
        projectEntity.setTitle(projectDto.getTitle());
        projectEntity.setDescription(projectDto.getDescription());
        projectEntity.setRegisteredDate(LocalDateTime.now());

        try {
            // 프로젝트 생성
            ProjectEntity saveProjectEntity = projectEntityRepository.save(projectEntity);

            if(!Objects.isNull(saveProjectEntity)) {

                // 프로젝트와 사용자 연동
                List<UserEntity> userEntityList = userEntityRepository.findByIdxIn(projectDto.getUsers().stream().map(user -> user.getKey()).collect(Collectors.toList()));
                userEntityList.forEach(user -> {
                    UserToProjectEntity userToProjectEntity = new UserToProjectEntity();
                    userToProjectEntity.setUserIdx(user.getIdx());
                    userToProjectEntity.setProjectIdx(saveProjectEntity.getIdx());
                    userToProjectEntityRepository.save(userToProjectEntity);
                });
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 프로젝트 생성시 프로젝트 코드 중복 체크
     * @param projectCode
     * @return
     */
    @Override
    public boolean checkProjectCode(String projectCode) {
        Long count = projectEntityRepository.countByProjectCode(projectCode);

        return count > 0 ? false : true;
    }


    @Override
    public Flux<ProjectDto> findByUserIdx(Long userIdx) {
        List<ProjectEntity> projectEntityList =  projectEntityRepository.findByUserIdx(userIdx);

        List<ProjectDto> projectDtoList = projectEntityList.stream()
                .map(projectEntity -> {

//                    projectEntity.getRegisteredDate()
                    return ProjectDto.builder()
                            .code(projectEntity.getProjectCode())
                            .title(projectEntity.getTitle())
                            .description(projectEntity.getDescription())
                            .registeredDate(projectEntity.getRegisteredDate())
                            .build();
                })
                .collect(Collectors.toList());


        return Flux.fromIterable(projectDtoList);
    }
}

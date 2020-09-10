package com.jin.issuesticker.user.repository;

import com.jin.issuesticker.user.models.UserToProjectEntity;
import com.jin.issuesticker.user.models.UserToProjectEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserToProjectEntityRepository extends JpaRepository<UserToProjectEntity, UserToProjectEntityPK> {

    List<UserToProjectEntity> findByUserIdx(Long userIdx);
}

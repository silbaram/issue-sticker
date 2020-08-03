package com.jin.issuesticker.common.repository;

import com.jin.issuesticker.common.models.UserToProjectEntity;
import com.jin.issuesticker.common.models.UserToProjectEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserToProjectEntityRepository extends JpaRepository<UserToProjectEntity, UserToProjectEntityPK> {

    List<UserToProjectEntity> findByUserIdx(Long userIdx);
}

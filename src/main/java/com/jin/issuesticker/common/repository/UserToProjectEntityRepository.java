package com.jin.issuesticker.common.repository;

import com.jin.issuesticker.common.models.UserToProjectEntity;
import com.jin.issuesticker.common.models.UserToProjectEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserToProjectEntityRepository extends JpaRepository<UserToProjectEntity, UserToProjectEntityPK> {
}

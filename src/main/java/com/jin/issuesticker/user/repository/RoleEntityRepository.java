package com.jin.issuesticker.user.repository;

import com.jin.issuesticker.user.enumcode.RoleCodeEnum;
import com.jin.issuesticker.user.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByRoleCode(RoleCodeEnum roleCode);
}

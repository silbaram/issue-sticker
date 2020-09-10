package com.jin.issuesticker.user.repository;

import com.jin.issuesticker.user.models.UserToRoleEntity;
import com.jin.issuesticker.user.models.UserToRoleEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserToRoleEntityRepository extends JpaRepository<UserToRoleEntity, UserToRoleEntityPK> {

}

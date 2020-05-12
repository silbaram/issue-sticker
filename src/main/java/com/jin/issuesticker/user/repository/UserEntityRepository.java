package com.jin.issuesticker.user.repository;

import com.jin.issuesticker.user.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 유저 엔티티 관련 Repository
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Long countById(String id);

    UserEntity findById(String id);
}

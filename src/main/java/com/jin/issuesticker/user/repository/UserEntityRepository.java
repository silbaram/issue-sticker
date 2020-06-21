package com.jin.issuesticker.user.repository;

import com.jin.issuesticker.user.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * 유저 엔티티 관련 Repository
 */
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    /**
     * 중복되는 user 정보가 있는지 검색
     * @param id
     * @return
     */
    Long countById(String id);

    /**
     * 사용자 로그인시 user 정보 검색
     * @param id
     * @param isAccess
     * @return
     */
    UserEntity findByIdAndIsAccess(String id, int isAccess);

    /**
     * 아이디 또는 사용자 이름으로 user 정보 검색
     * @param id
     * @param username
     * @return
     */
    List<UserEntity> findByIdLikeOrUsernameLike(String id, String username);
}

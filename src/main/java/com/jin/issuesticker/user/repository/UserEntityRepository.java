package com.jin.issuesticker.user.repository;

import com.jin.issuesticker.user.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query(value = "select u from UserEntity u join fetch u.userToRoleEntityList r join fetch r.roleEntity where u.id = :id and u.isAccess = :isAccess")
    UserEntity findByIdAndIsAccess(@Param(value = "id") String id, @Param(value = "isAccess") int isAccess);

    /**
     * 아이디 또는 사용자 이름으로 user 정보 검색
     * @param id
     * @param username
     * @return
     */
    List<UserEntity> findByIdContainingOrUsernameContaining(String id, String username);

    /**
     * 프로젝트에 연동할 사용자들 정보 검색
     * @param idx
     * @return
     */
    List<UserEntity> findByIdxIn(List<Long> idx);
}

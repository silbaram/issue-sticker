package com.jin.issuesticker.user.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name = "t_user_to_role", schema = "issuesticker")
@IdClass(UserToRoleEntityPK.class)
public class UserToRoleEntity {

    @Id
    @Column(name = "user_idx")
    private Long userIdx;

    @Id
    @Column(name = "role_idx")
    private Long roleIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", insertable = false, updatable = false)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_idx", insertable = false, updatable = false)
    private RoleEntity roleEntity;
}

package com.jin.issuesticker.user.models;

import com.jin.issuesticker.user.enumcode.RoleCodeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter @Setter
@Entity
@Table(name = "t_role", schema = "issuesticker")
public class RoleEntity {

    @Id
    @Column(name = "idx")
    private Long idx;

    @Basic
    @Column(name = "role_code")
    @Enumerated(value = EnumType.STRING)
    private RoleCodeEnum roleCode;

    @OneToMany(mappedBy = "roleEntity", fetch = FetchType.LAZY)
    private Set<UserToRoleEntity> userToRoleEntitySet = new HashSet<>();
}

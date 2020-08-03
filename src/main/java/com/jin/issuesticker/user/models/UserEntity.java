package com.jin.issuesticker.user.models;

import com.jin.issuesticker.common.models.UserToProjectEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "t_user", schema = "issuesticker")
public class UserEntity {
    @Id @Column(name = "idx") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "is_access")
    private int isAccess;

    @Column(name = "registered_date")
    private Timestamp registeredDate;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    private List<UserToProjectEntity> userToProjectEntityList = new ArrayList<>();
}

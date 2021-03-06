package com.jin.issuesticker.common.models;

import com.jin.issuesticker.project.models.ProjectEntity;
import com.jin.issuesticker.user.models.UserEntity;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "t_user_to_project", schema = "issuesticker")
@IdClass(UserToProjectEntityPK.class)
public class UserToProjectEntity {

    @Id
    @Column(name = "user_idx")
    private Long userIdx;

    @Id
    @Column(name = "project_idx")
    private Long projectIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", insertable = false, updatable = false)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_idx", insertable = false, updatable = false)
    private ProjectEntity projectEntity;
}

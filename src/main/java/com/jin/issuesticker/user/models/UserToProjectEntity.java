package com.jin.issuesticker.user.models;

import com.jin.issuesticker.project.models.ProjectEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
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

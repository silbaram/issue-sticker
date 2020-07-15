package com.jin.issuesticker.project.models;

import com.jin.issuesticker.common.models.UserToProjectEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "t_project", schema = "issuesticker")
public class ProjectEntity {

    @Id @Column(name = "idx") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "registered_date")
    private LocalDateTime registeredDate;

    @Column(name = "modified_date")
    private LocalDateTime  modifiedDate;

    @OneToMany(mappedBy = "projectEntity", fetch = FetchType.LAZY)
    private List<UserToProjectEntity> userToProjectEntityList = new ArrayList<>();
}

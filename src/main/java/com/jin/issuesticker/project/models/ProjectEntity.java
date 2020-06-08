package com.jin.issuesticker.project.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "t_project", schema = "issuesticker")
public class ProjectEntity {

    @Id @Column(name = "idx") @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;

    @Column(name = "project_code")
    String projectCode;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "registered_date")
    Timestamp registeredDate;

    @Column(name = "modified_date")
    Timestamp modifiedDate;
}

package com.jin.issuesticker.user.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "t_user", schema = "issuesticker")
public class UserEntity {
    @Id @Column(name = "idx") @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;

    @Column(name = "id")
    String id;

    @Column(name = "password")
    String password;

    @Column(name = "name")
    String username;

    @Column(name = "email")
    String email;

    @Column(name = "registered_date")
    Timestamp registeredDate;

    @Column(name = "modified_date")
    Timestamp modifiedDate;
}

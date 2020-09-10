package com.jin.issuesticker.user.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;


@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class UserToRoleEntityPK implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "user_idx")
    private Long userIdx;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "role_idx")
    private Long roleIdx;
}

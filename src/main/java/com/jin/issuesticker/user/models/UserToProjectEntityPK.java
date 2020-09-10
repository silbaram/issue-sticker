package com.jin.issuesticker.user.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


public class UserToProjectEntityPK implements Serializable {

    @Id
    @Column(name = "user_idx")
    private Long userIdx;

    @Id
    @Column(name = "project_idx")
    private Long projectIdx;

    public UserToProjectEntityPK(){}
    public UserToProjectEntityPK(Long userIdx, Long projectIdx) {
        this.userIdx = userIdx;
        this.projectIdx = projectIdx;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserToProjectEntityPK that = (UserToProjectEntityPK) o;
        return Objects.equals(userIdx, that.userIdx) &&
                Objects.equals(projectIdx, that.projectIdx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdx, projectIdx);
    }
}

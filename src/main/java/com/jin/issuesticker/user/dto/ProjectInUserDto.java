package com.jin.issuesticker.user.dto;

import lombok.Builder;
import lombok.Data;


@Data
public class ProjectInUserDto {

    private Long idx;
    private String username;

    //프로젝트 등록시 사용자 정보
    private Long key;
    private String label;


    @Builder
    public ProjectInUserDto(Long idx, String username) {
        this.idx = idx;
        this.username = username;
    }
}

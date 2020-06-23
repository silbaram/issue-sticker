package com.jin.issuesticker.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class ProjectInUserDto {

    @Getter @Setter
    private Long idx;

    @Getter @Setter
    private String username;


    @Builder
    public ProjectInUserDto(Long idx, String username) {
        this.idx = idx;
        this.username = username;
    }
}

package com.jin.issuesticker.project.dto;

import com.jin.issuesticker.user.dto.ProjectInUserDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
public class ProjectDto {
    private String code;
    private String title;
    private String description;
    private List<ProjectInUserDto> users;

    @Builder
    public ProjectDto(String code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }
}

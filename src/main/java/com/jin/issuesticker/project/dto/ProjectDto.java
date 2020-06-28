package com.jin.issuesticker.project.dto;

import com.jin.issuesticker.user.dto.ProjectInUserDto;
import lombok.Data;

import java.util.List;


@Data
public class ProjectDto {
    private String code;
    private String title;
    private String description;
    private List<ProjectInUserDto> users;
}

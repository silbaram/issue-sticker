package com.jin.issuesticker.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jin.issuesticker.user.dto.ProjectInUserDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class ProjectDto {
    private String code;
    private String title;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime registeredDate;
    private List<ProjectInUserDto> users;

    @Builder
    public ProjectDto(String code, String title, String description, LocalDateTime registeredDate) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.registeredDate = registeredDate;
    }
}

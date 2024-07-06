package com.moviebooking.movie.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithProjectsDTO {
    private int id;
    private String name;
    private String email;
    private String technicalSkill;
    private Set<ProjectDTO> projects;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProjectDTO {
        private int id;
        private String projectName;
        private String technologyUsed;
    }
}

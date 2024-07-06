package com.moviebooking.movie.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectWithEmployeesDTO {
    private int id;
    private String projectName;
    private String technologyUsed;
    private Set<EmployeeDTO> employees;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmployeeDTO {
        private int id;
        private String name;
        private String email;
        private String technicalSkill;
    }
}

package com.moviebooking.movie.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProjectsToEmployeeDTO {
    private int employeeId;
    private Set<Integer> projectIds;
}

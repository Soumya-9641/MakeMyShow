package com.moviebooking.movie.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.ProjectWithEmployeesDTO;
import com.moviebooking.movie.model.Project;
import com.moviebooking.movie.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectWithEmployeesDTO getProjectWithEmployees(int projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        if (!optionalProject.isPresent()) {
            throw new RuntimeException("Project not found with id: " + projectId);
        }

        Project project = optionalProject.get();
        ProjectWithEmployeesDTO projectDTO = new ProjectWithEmployeesDTO();
        projectDTO.setId(project.getId());
        projectDTO.setProjectName(project.getProjectName());
        projectDTO.setTechnologyUsed(project.getTechnologyUsed());
        projectDTO.setEmployees(project
                .getEmployees().stream().map(employee -> new ProjectWithEmployeesDTO.EmployeeDTO(employee.getId(),
                        employee.getName(), employee.getEmail(), employee.getTechnicalSkill()))
                .collect(Collectors.toSet()));

        return projectDTO;
    }
}

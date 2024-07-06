package com.moviebooking.movie.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.AddProjectsToEmployeeDTO;
import com.moviebooking.movie.dto.EmployeeWithProjectsDTO;
import com.moviebooking.movie.model.Employee;
import com.moviebooking.movie.model.Project;
import com.moviebooking.movie.repository.EmployeeRepository;
import com.moviebooking.movie.repository.ProjectRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Employee addProjectsToEmployee(AddProjectsToEmployeeDTO dto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(dto.getEmployeeId());
        if (!optionalEmployee.isPresent()) {
            throw new RuntimeException("Employee not found with id: " + dto.getEmployeeId());
        }

        Employee employee = optionalEmployee.get();
        Set<Project> projects = new HashSet<>();
        for (Integer projectId : dto.getProjectIds()) {
            Optional<Project> optionalProject = projectRepository.findById(projectId);
            if (optionalProject.isPresent()) {
                projects.add(optionalProject.get());
            }
        }

        employee.getProjects().addAll(projects);
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    public EmployeeWithProjectsDTO getEmployeeWithProjects(int employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (!optionalEmployee.isPresent()) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }

        Employee employee = optionalEmployee.get();
        EmployeeWithProjectsDTO employeeDTO = new EmployeeWithProjectsDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setTechnicalSkill(employee.getTechnicalSkill());
        employeeDTO
                .setProjects(
                        employee.getProjects().stream()
                                .map(project -> new EmployeeWithProjectsDTO.ProjectDTO(project.getId(),
                                        project.getProjectName(), project.getTechnologyUsed()))
                                .collect(Collectors.toSet()));

        return employeeDTO;
    }
}

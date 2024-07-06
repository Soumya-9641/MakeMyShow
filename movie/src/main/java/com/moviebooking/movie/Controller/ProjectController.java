package com.moviebooking.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.ProjectWithEmployeesDTO;
import com.moviebooking.movie.model.Project;
import com.moviebooking.movie.repository.EmployeeRepository;
import com.moviebooking.movie.repository.ProjectRepository;
import com.moviebooking.movie.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private EmployeeRepository employeerepo;
    @Autowired
    private ProjectRepository projectrepo;

    @Autowired
    private ProjectService projectService;

    @PostMapping("/createproject")
    public String createProject(@RequestBody Project project) {

        Project newproject = new Project();
        newproject.setProjectName(project.getProjectName());
        newproject.setTechnologyUsed(project.getTechnologyUsed());

        projectrepo.save(newproject);
        System.out.println(newproject);

        return "Project created successfully";
    }

    @GetMapping("/{projectId}/employees")
    public ResponseEntity<ProjectWithEmployeesDTO> getProjectWithEmployees(@PathVariable int projectId) {
        ProjectWithEmployeesDTO projectDTO = projectService.getProjectWithEmployees(projectId);
        return ResponseEntity.ok(projectDTO);
    }

}

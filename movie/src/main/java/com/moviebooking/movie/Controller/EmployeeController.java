package com.moviebooking.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.AddProjectsToEmployeeDTO;
import com.moviebooking.movie.dto.EmployeeWithProjectsDTO;
import com.moviebooking.movie.model.Employee;
import com.moviebooking.movie.repository.EmployeeRepository;
import com.moviebooking.movie.repository.ProjectRepository;
import com.moviebooking.movie.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeerepo;
    @Autowired
    private ProjectRepository projectrepo;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/createemployee")
    public String createEmployee(@RequestBody Employee empl) {
        System.out.println("Create a new employee");

        Employee employee = new Employee();
        employee.setEmail(empl.getEmail());
        employee.setName(empl.getName());
        employee.setTechnicalSkill(empl.getTechnicalSkill());
        employee = employeerepo.save(employee);
        System.out.println("Employee save " + employee + "\nthis ");
        return "employee created";

    }

    @GetMapping("/getEmployee/{id}")
    public String getEployee(@PathVariable(name = "id") Integer id) {
        System.out.println("Fetch Employee and Project details.");
        @SuppressWarnings("deprecation")
        Employee employee = employeerepo.getById(id);
        System.out.println(employee);
        return "hello";
    }

    @PostMapping("/add-projects")
    public ResponseEntity<Employee> addProjectsToEmployee(@RequestBody AddProjectsToEmployeeDTO dto) {
        Employee updatedEmployee = employeeService.addProjectsToEmployee(dto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/{employeeId}/projects")
    public ResponseEntity<EmployeeWithProjectsDTO> getEmployeeWithProjects(@PathVariable int employeeId) {
        EmployeeWithProjectsDTO employeeDTO = employeeService.getEmployeeWithProjects(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

}

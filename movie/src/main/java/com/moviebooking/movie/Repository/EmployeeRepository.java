package com.moviebooking.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.movie.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

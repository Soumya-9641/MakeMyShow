package com.moviebooking.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.movie.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}

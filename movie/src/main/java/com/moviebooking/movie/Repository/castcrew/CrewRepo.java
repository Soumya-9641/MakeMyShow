package com.moviebooking.movie.repository.castcrew;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.movie.model.Crew;

public interface CrewRepo extends JpaRepository<Crew, Long> {

}

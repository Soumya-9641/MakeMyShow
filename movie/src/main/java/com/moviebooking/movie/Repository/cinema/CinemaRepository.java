package com.moviebooking.movie.repository.cinema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.movie.model.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}

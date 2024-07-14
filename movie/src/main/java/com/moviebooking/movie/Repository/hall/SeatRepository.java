package com.moviebooking.movie.repository.hall;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.movie.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

}

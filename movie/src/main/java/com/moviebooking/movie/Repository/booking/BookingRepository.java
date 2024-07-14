package com.moviebooking.movie.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.movie.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}

package com.moviebooking.movie.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.movie.model.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {

}

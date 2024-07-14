package com.moviebooking.movie.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.movie.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

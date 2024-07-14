package com.moviebooking.movie.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.booking.BookingDetailsRequestDTO;
import com.moviebooking.movie.dto.booking.BookingDetailsResponseDTO;
import com.moviebooking.movie.dto.booking.BookingRequestDTO;
import com.moviebooking.movie.dto.booking.BookingResponseDTO;
import com.moviebooking.movie.service.booking.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public BookingResponseDTO createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return bookingService.createBooking(bookingRequestDTO);
    }

    @GetMapping("/{id}")
    public BookingResponseDTO getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }

    @PostMapping("/createBookingDetails")
    public ResponseEntity<BookingDetailsResponseDTO> createBookingDetails(
            @RequestBody BookingDetailsRequestDTO request) {
        BookingDetailsResponseDTO bookingDetailsResponse = bookingService.createBookingDetails(request);
        return ResponseEntity.ok(bookingDetailsResponse);
    }

    @GetMapping("/bookingDetails/{id}")
    public ResponseEntity<BookingDetailsResponseDTO> getBookingDetails(@PathVariable Long id) {
        BookingDetailsResponseDTO bookingDetailsResponse = bookingService.getBookingDetails(id);
        return ResponseEntity.ok(bookingDetailsResponse);
    }
}

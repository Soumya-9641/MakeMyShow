package com.moviebooking.movie.controller.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.seat.SeatRequestDTO;
import com.moviebooking.movie.dto.seat.SeatResponseDTO;
import com.moviebooking.movie.service.cinema.SeatService;

@RestController
@RequestMapping("/api/seat")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping
    public SeatResponseDTO createSeat(@RequestBody SeatRequestDTO seatRequestDTO) {
        return seatService.createSeat(seatRequestDTO);
    }

    @GetMapping("/{id}")
    public SeatResponseDTO getSeat(@PathVariable Long id) {
        return seatService.getSeat(id);
    }
}

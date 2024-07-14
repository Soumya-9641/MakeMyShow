package com.moviebooking.movie.controller.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.cinema.CinemaRequestDto;
import com.moviebooking.movie.dto.cinema.CinemaResponseDto;
import com.moviebooking.movie.service.cinema.CinemaService;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaservice;

    @PostMapping("/createCinema")
    public ResponseEntity<CinemaResponseDto> createCinema(@RequestBody CinemaRequestDto request) {
        CinemaResponseDto response = cinemaservice.createCinema(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{cinemaId}")
    public ResponseEntity<CinemaResponseDto> getCinemaWithHalls(@PathVariable Long cinemaId) {
        CinemaResponseDto cinemaResponse = cinemaservice.getCinemaWithHalls(cinemaId);
        return ResponseEntity.ok(cinemaResponse);
    }

}

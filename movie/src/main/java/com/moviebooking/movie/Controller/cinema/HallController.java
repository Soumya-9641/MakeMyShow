package com.moviebooking.movie.controller.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.hall.GetHallResponse;
import com.moviebooking.movie.dto.hall.HallRequestDto;
import com.moviebooking.movie.dto.hall.HallResponseDto;
import com.moviebooking.movie.service.cinema.HallService;

@RestController
@RequestMapping("/api/hall")
public class HallController {

    @Autowired
    private HallService hallservice;

    @PostMapping("/createHall")
    public ResponseEntity<HallResponseDto> createHall(@RequestBody HallRequestDto request) {
        HallResponseDto response = hallservice.createHall(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{hallId}")
    public ResponseEntity<GetHallResponse> getHall(@PathVariable Long hallId) {
        GetHallResponse hallResponse = hallservice.getHall(hallId);
        return ResponseEntity.ok(hallResponse);
    }
}

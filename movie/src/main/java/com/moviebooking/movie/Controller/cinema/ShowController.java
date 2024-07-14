package com.moviebooking.movie.controller.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.show.GetShowDTO;
import com.moviebooking.movie.dto.show.ShowDTO;
import com.moviebooking.movie.dto.show.ShowResponseDTO;
import com.moviebooking.movie.service.cinema.ShowService;

@RestController
@RequestMapping("/api/show")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping
    public ResponseEntity<ShowResponseDTO> createShow(@RequestBody ShowDTO showDTO) {
        ShowResponseDTO createdShow = showService.createShow(showDTO);
        return ResponseEntity.ok(createdShow);
    }

    @GetMapping("/{id}")
    public GetShowDTO getShow(@PathVariable Long id) {
        return showService.getShow(id);
    }
}

package com.moviebooking.movie.controller.moviecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.movie.GetMovieResponse;
import com.moviebooking.movie.dto.movie.MovieRequest;
import com.moviebooking.movie.dto.movie.MovieResponse;
import com.moviebooking.movie.service.movie.MovieService;
import com.moviebooking.movie.service.movie.MovieServiceImpl;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @Autowired
    private MovieService movieservice;
    @Autowired
    private MovieServiceImpl movieserviceimpl;

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@RequestBody MovieRequest request) {
        MovieResponse response = movieservice.createMovie(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<GetMovieResponse> getMovie(@PathVariable Long movieId) {
        GetMovieResponse response = movieservice.getMovie(movieId);
        return ResponseEntity.ok(response);
    }
}

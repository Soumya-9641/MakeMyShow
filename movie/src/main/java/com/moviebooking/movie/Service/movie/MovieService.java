package com.moviebooking.movie.service.movie;

import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.movie.GetMovieResponse;
import com.moviebooking.movie.dto.movie.MovieRequest;
import com.moviebooking.movie.dto.movie.MovieResponse;

@Service
public interface MovieService {

    MovieResponse createMovie(MovieRequest request);

    GetMovieResponse getMovie(Long movieId);

}

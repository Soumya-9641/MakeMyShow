package com.moviebooking.movie.service.review;

import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.review.ReviewDTO;

@Service
public interface ReviewInterface {
    String createReview(ReviewDTO request, Long movieId);
}

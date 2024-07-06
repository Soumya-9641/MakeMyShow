package com.moviebooking.movie.controller.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.review.ReviewDTO;
import com.moviebooking.movie.service.review.ReviewInterface;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewInterface reviewservice;

    @PostMapping("/{movieId}")
    public ResponseEntity<String> createReview(@PathVariable Long movieId, @RequestBody ReviewDTO request) {
        System.out.println(request);
        String response = reviewservice.createReview(request, movieId);
        return ResponseEntity.ok(response);
    }
}

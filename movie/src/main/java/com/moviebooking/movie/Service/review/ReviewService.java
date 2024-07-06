package com.moviebooking.movie.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.review.ReviewDTO;
import com.moviebooking.movie.model.Movie;
import com.moviebooking.movie.model.Review;
import com.moviebooking.movie.repository.movie.MovieRepository;
import com.moviebooking.movie.repository.review.ReviewRepository;

@Service
public class ReviewService implements ReviewInterface {
    @Autowired
    private ReviewRepository reviewrepository;
    @Autowired
    private MovieRepository movierepository;

    // @Override
    // public String createReview(ReviewDTO review, Integer movieId) {
    // System.out.println(review.getContent());
    // // Movie movie = movierepository.findById(review.getMovieId()).orElseThrow();
    // // System.out.println(movie);
    // return "Review creeted successfully";
    // }

    @Override
    public String createReview(ReviewDTO request, Long movieId) {
        Movie movie = movierepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("movie not found"));

        System.out.println(movie);
        Review review = new Review();
        review.setUserId(request.getUserId());
        review.setContent(request.getContent());
        review.setMovie(movie);
        reviewrepository.save(review);
        return "Review created successfully for movie ID " + movieId;
        // throw new UnsupportedOperationException("Not supported yet.");
    }

}

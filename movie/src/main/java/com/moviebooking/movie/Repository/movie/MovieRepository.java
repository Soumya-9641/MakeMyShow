package com.moviebooking.movie.repository.movie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebooking.movie.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.languages LEFT JOIN FETCH m.hallTypes WHERE m.movie_id = :movieId")
    Optional<Movie> findByIdWithAssociations(Long movieId);
}

package com.moviebooking.movie.repository.castcrew;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.movie.model.Cast;

public interface CastRepo extends JpaRepository<Cast, Long> {

}

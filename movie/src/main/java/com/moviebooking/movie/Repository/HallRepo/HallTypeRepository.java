package com.moviebooking.movie.Repository.HallRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.movie.Model.HallType;

@Repository
public interface HallTypeRepository extends JpaRepository<HallType, Long> {

}

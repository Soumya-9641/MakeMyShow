package com.moviebooking.movie.repository.hallrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.movie.model.HallType;

@Repository
public interface HallTypeRepository extends JpaRepository<HallType, Long> {

}

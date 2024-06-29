package com.moviebooking.movie.Repository.HallRepo;

import org.springframework.stereotype.Service;

import com.moviebooking.movie.Dto.HallType.HallTypeRequest;
import com.moviebooking.movie.Dto.HallType.HallTypeResponse;

@Service
public interface HallTypeService {
    HallTypeResponse createHallType(HallTypeRequest request);
}

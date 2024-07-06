package com.moviebooking.movie.service.halltype;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.halltype.HallTypeRequest;
import com.moviebooking.movie.dto.halltype.HallTypeResponse;

@Service
public interface HallTypeService {
    HallTypeResponse createHallType(HallTypeRequest request);

    List<HallTypeResponse> getHallType();
}

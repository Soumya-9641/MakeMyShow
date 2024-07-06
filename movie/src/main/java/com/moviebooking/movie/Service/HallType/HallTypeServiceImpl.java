package com.moviebooking.movie.service.halltype;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.halltype.HallTypeRequest;
import com.moviebooking.movie.dto.halltype.HallTypeResponse;
import com.moviebooking.movie.model.HallType;
import com.moviebooking.movie.repository.hallrepo.HallTypeRepository;

@Service
public class HallTypeServiceImpl implements HallTypeService {
    @Autowired
    private HallTypeRepository halltyperepo;

    @Override
    public HallTypeResponse createHallType(HallTypeRequest request) {
        HallType hallType = new HallType();
        hallType.setHallTypeName(request.getHallTypeName());
        HallType savedHallType = halltyperepo.save(hallType);
        HallTypeResponse response = new HallTypeResponse();
        response.setHallTypeId(savedHallType.getHallTypeId());
        response.setHallTypeName(savedHallType.getHallTypeName());
        return response;
    }

    @Override
    public List<HallTypeResponse> getHallType() {
        List<HallType> halls = halltyperepo.findAll();
        return halls.stream()
                .map(hall -> new HallTypeResponse(hall.getHallTypeId(), hall.getHallTypeName()))
                .collect(Collectors.toList());
        // throw new UnsupportedOperationException("Not supported yet.");
    }
}

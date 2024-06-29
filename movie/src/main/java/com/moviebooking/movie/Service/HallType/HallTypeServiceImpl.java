package com.moviebooking.movie.Service.HallType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.Dto.HallType.HallTypeRequest;
import com.moviebooking.movie.Dto.HallType.HallTypeResponse;
import com.moviebooking.movie.Repository.HallRepo.HallTypeRepository;
import com.moviebooking.movie.Repository.HallRepo.HallTypeService;

@Service
public class HallTypeServiceImpl implements HallTypeService {
    @Autowired
    private HallTypeRepository halltyperepo;

    @Override
    public HallTypeResponse createHallType(HallTypeRequest request) {
        // HallType halltype= new HallType();
        // halltype.setHallTypeName(request.getHallTypeName());
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

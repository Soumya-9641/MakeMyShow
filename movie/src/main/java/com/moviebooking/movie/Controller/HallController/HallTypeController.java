package com.moviebooking.movie.Controller.HallController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.Dto.HallType.HallTypeRequest;
import com.moviebooking.movie.Dto.HallType.HallTypeResponse;
import com.moviebooking.movie.Repository.HallRepo.HallTypeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/hall")

public class HallTypeController {

    @Autowired
    private HallTypeService halltypeservice;

    @PostMapping
    public ResponseEntity<HallTypeResponse> createHallType(@RequestBody HallTypeRequest request) {
        HallTypeResponse response = halltypeservice.createHallType(request);
        return ResponseEntity.ok(response);

    }
}

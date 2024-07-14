package com.moviebooking.movie.controller.hallcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.halltype.HallTypeRequest;
import com.moviebooking.movie.dto.halltype.HallTypeResponse;
import com.moviebooking.movie.service.halltype.HallTypeService;

@RestController
@RequestMapping("/api/halltype")

public class HallTypeController {

    @Autowired
    private HallTypeService halltypeservice;

    @PostMapping
    public ResponseEntity<HallTypeResponse> createHallType(@RequestBody HallTypeRequest request) {
        HallTypeResponse response = halltypeservice.createHallType(request);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<HallTypeResponse>> getHalls() {
        List<HallTypeResponse> response = halltypeservice.getHallType();
        return ResponseEntity.ok(response);
    }
}

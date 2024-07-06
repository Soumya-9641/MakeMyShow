package com.moviebooking.movie.controller.castcrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.cast.CastRequest;
import com.moviebooking.movie.dto.cast.CatsReponse;
import com.moviebooking.movie.dto.cast.CrewRequest;
import com.moviebooking.movie.dto.cast.CrewResponse;
import com.moviebooking.movie.service.castcrew.CastService;

@RestController
@RequestMapping("/api/cast")
public class CastController {
    @Autowired
    private CastService castservice;

    @PostMapping("/createCats")
    public ResponseEntity<CatsReponse> addCast(@RequestBody CastRequest request) {

        CatsReponse castResponse = castservice.addCast(request);
        return ResponseEntity.ok(castResponse);

    }

    @PostMapping("/createCrew")
    public ResponseEntity<CrewResponse> createCrew(@RequestBody CrewRequest request) {
        CrewResponse crewresponse = castservice.createCrew(request);
        return ResponseEntity.ok(crewresponse);
    }
}

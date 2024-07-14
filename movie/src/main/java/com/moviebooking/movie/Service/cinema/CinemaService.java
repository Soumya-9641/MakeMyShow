package com.moviebooking.movie.service.cinema;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.cinema.CinemaRequestDto;
import com.moviebooking.movie.dto.cinema.CinemaResponseDto;
import com.moviebooking.movie.dto.hall.HallResponseDto;
import com.moviebooking.movie.model.Cinema;
import com.moviebooking.movie.model.Hall;
import com.moviebooking.movie.repository.cinema.CinemaRepository;
import com.moviebooking.movie.repository.hall.HallRepository;

import jakarta.transaction.Transactional;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemarepo;
    @Autowired
    private HallRepository hallrepo;

    public CinemaResponseDto createCinema(CinemaRequestDto request) {
        Cinema cinema = new Cinema();
        cinema.setName(request.getName());
        cinema.setLocation(request.getLocation());
        cinema.setCreatedAt(LocalDateTime.now());
        cinema.setUpdatedAt(LocalDateTime.now());

        Set<Hall> halls = new HashSet<>();
        for (Long hallId : request.getHallIds()) {
            Hall hall = hallrepo.findById(hallId)
                    .orElseThrow(() -> new RuntimeException("Hall not found with id: " + hallId));
            halls.add(hall);
        }
        cinema.setHalls(halls);

        Cinema savedCinema = cinemarepo.save(cinema);

        CinemaResponseDto response = new CinemaResponseDto();
        response.setCinemaId(savedCinema.getCinemaId());
        response.setCreatedAt(savedCinema.getCreatedAt());
        response.setUpdatedAt(savedCinema.getUpdatedAt());
        response.setName(savedCinema.getName());
        response.setLocation(savedCinema.getLocation());

        List<HallResponseDto> hallResponses = savedCinema.getHalls().stream()
                .map(hall -> {
                    HallResponseDto hallResponse = new HallResponseDto();
                    hallResponse.setHallId(hall.getHallId());
                    hallResponse.setHallName(hall.getHallName());
                    return hallResponse;
                })
                .collect(Collectors.toList());

        response.setHalls(hallResponses);
        return response;

    }

    @Transactional
    public CinemaResponseDto getCinemaWithHalls(Long cinemaId) {
        Cinema cinema = cinemarepo.findById(cinemaId)
                .orElseThrow(() -> new RuntimeException("Cinema not found with id: " + cinemaId));

        CinemaResponseDto cinemaResponse = new CinemaResponseDto();
        cinemaResponse.setCinemaId(cinema.getCinemaId());
        cinemaResponse.setName(cinema.getName());
        cinemaResponse.setLocation(cinema.getLocation());
        cinemaResponse.setCreatedAt(cinema.getCreatedAt());
        cinemaResponse.setUpdatedAt(cinema.getUpdatedAt());
        System.out.println(cinema.getHalls());
        List<HallResponseDto> hallResponses = cinema.getHalls().stream()
                .map(hall -> {
                    HallResponseDto hallResponse = new HallResponseDto();
                    hallResponse.setHallId(hall.getHallId());
                    hallResponse.setHallName(hall.getHallName());
                    hallResponse.setCreatedAt(hall.getCreatedAt());
                    hallResponse.setUpdatedAt(hall.getUpdatedAt());
                    return hallResponse;
                })
                .collect(Collectors.toList());
        cinemaResponse.setHalls(hallResponses);

        return cinemaResponse;
    }
}

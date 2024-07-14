package com.moviebooking.movie.service.cinema;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.hall.CinemaResponse;
import com.moviebooking.movie.dto.hall.GetHallResponse;
import com.moviebooking.movie.dto.hall.HallRequestDto;
import com.moviebooking.movie.dto.hall.HallResponseDto;
import com.moviebooking.movie.dto.halltype.HallTypeResponse;
import com.moviebooking.movie.model.Hall;
import com.moviebooking.movie.model.HallType;
import com.moviebooking.movie.repository.hall.HallRepository;
import com.moviebooking.movie.repository.hallrepo.HallTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class HallService {
    @Autowired
    private HallRepository hallrepo;
    @Autowired
    private HallTypeRepository hallTypeRepo;
    // @Autowired
    // private HallResponseDto hallresponse;

    public HallResponseDto createHall(HallRequestDto request) {
        Hall hall = new Hall();
        hall.setHallName(request.getHallName());
        hall.setCreatedAt(LocalDateTime.now());
        hall.setUpdatedAt(LocalDateTime.now());
        Set<HallType> hallTypes = new HashSet<>();
        for (Long hallTypeId : request.getHallTypeIds()) {
            HallType hallType = hallTypeRepo.findById(hallTypeId)
                    .orElseThrow(() -> new RuntimeException("HallType not found with id: " + hallTypeId));
            hallTypes.add(hallType);
        }
        hall.setHallTypes(hallTypes);
        Hall savedHall = hallrepo.save(hall);
        HallResponseDto response = new HallResponseDto();
        response.setHallId(savedHall.getHallId());
        response.setHallName(savedHall.getHallName());
        response.setCreatedAt(savedHall.getCreatedAt());
        response.setUpdatedAt(savedHall.getUpdatedAt());
        Set<HallTypeResponse> halltypes = savedHall.getHallTypes().stream().map(halltype -> {
            HallTypeResponse halltyperesponse = new HallTypeResponse();

            halltyperesponse.setHallTypeId(halltype.getHallTypeId());
            halltyperesponse.setHallTypeName(halltype.getHallTypeName());
            return halltyperesponse;
        }).collect(Collectors.toSet());

        response.setHallTypes(halltypes);
        return response;
    }

    @Transactional
    public GetHallResponse getHall(Long hallId) {
        Hall hall = hallrepo.findById(hallId)
                .orElseThrow(() -> new RuntimeException("Hall not found with id: " + hallId));

        List<CinemaResponse> cinemaResponses = hall.getCinemas().stream()
                .map(cinema -> new CinemaResponse(
                        cinema.getCinemaId(),
                        cinema.getName(),
                        cinema.getLocation(),
                        cinema.getCreatedAt(),
                        cinema.getUpdatedAt()))
                .collect(Collectors.toList());

        List<HallTypeResponse> hallTypeResponses = hall.getHallTypes().stream()
                .map(hallType -> new HallTypeResponse(
                        hallType.getHallTypeId(),
                        hallType.getHallTypeName()))
                .collect(Collectors.toList());

        return new GetHallResponse(
                hall.getHallId(),
                hall.getHallName(),
                hall.getCreatedAt(),
                hall.getUpdatedAt(),
                cinemaResponses,
                hallTypeResponses);

    }

    // public GetHallResponse getHallById(Long hallId) {
    // Hall hall = hallrepo.findById(hallId)
    // .orElseThrow(() -> new RuntimeException("Hall not found"));

    // Set<HallTypeResponse> hallTypes = hall.getHallTypes().stream()
    // .map(hallType -> new HallTypeResponse(hallType.getId(), hallType.getName()))
    // .collect(Collectors.toSet());

    // return new GetHallResponse(
    // hall.getId(),
    // hall.getName(),
    // hall.getCreatedAt(),
    // hall.getUpdatedAt(),
    // movies,
    // hallTypes
    // );
    // }
}

// let data = {};
// let cards =
// document.querySelectorAll('div.card.direct-chat.direct-chat-primary');
// cards.forEach(card => {
// let subjectName = card.querySelector('h6.card-title').innerText.split(':
// ')[1].trim();

// if (!data[subjectName]) {
// data[subjectName] = [];
// }

// let rows = card.querySelectorAll('.form-options-item');

// rows.forEach(row => {
// let questionId = row.children[1].innerText.trim();
// let correctAns = row.children[2].innerText.trim();
// data[subjectName].push(`${questionId}:${correctAns}`)
// });
// });

// for(let key of Object.keys(data)){
// data[key] = data[key].join(';')
// }

// let jsonData = JSON.stringify(data, null, 2);

// console.log(data);
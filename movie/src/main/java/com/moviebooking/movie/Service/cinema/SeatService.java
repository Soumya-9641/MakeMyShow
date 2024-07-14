package com.moviebooking.movie.service.cinema;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.seat.SeatRequestDTO;
import com.moviebooking.movie.dto.seat.SeatResponseDTO;
import com.moviebooking.movie.model.Hall;
import com.moviebooking.movie.model.Seat;
import com.moviebooking.movie.repository.hall.HallRepository;
import com.moviebooking.movie.repository.hall.SeatRepository;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private HallRepository hallRepository;

    public SeatResponseDTO createSeat(SeatRequestDTO request) {

        Optional<Hall> hallOptional = hallRepository.findById(request.getHallId());
        if (hallOptional.isPresent()) {
            Hall hall = hallOptional.get();

            Seat seat = new Seat();
            seat.setSeatNumber(request.getSeatNumber());
            seat.setType(request.getType());
            seat.setHallType(request.getHallType());
            seat.setHall(hall);
            seat.setCreatedAt(LocalDateTime.now());
            seat.setUpdatedAt(LocalDateTime.now());

            Seat savedSeat = seatRepository.save(seat);

            return new SeatResponseDTO(
                    savedSeat.getId(),
                    savedSeat.getSeatNumber(),
                    savedSeat.getType(),
                    savedSeat.getHallType(),
                    savedSeat.getCreatedAt(),
                    savedSeat.getUpdatedAt(),
                    hall.getHallId(),
                    hall.getHallName());
        } else {
            throw new RuntimeException("Hall not found");
        }
    }

    public SeatResponseDTO getSeat(Long id) {
        Optional<Seat> seatOptional = seatRepository.findById(id);

        if (seatOptional.isPresent()) {
            Seat seat = seatOptional.get();
            Hall hall = seat.getHall();

            return new SeatResponseDTO(
                    seat.getId(),
                    seat.getSeatNumber(),
                    seat.getType(),
                    seat.getHallType(),
                    seat.getCreatedAt(),
                    seat.getUpdatedAt(),
                    hall.getHallId(),
                    hall.getHallName());
        } else {
            throw new RuntimeException("Seat not found with id: " + id);
        }
    }
}

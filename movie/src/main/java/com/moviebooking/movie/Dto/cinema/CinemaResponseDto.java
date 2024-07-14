package com.moviebooking.movie.dto.cinema;

import java.time.LocalDateTime;
import java.util.List;

import com.moviebooking.movie.dto.hall.HallResponseDto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CinemaResponseDto {
    private Long cinemaId;
    private String name;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<HallResponseDto> halls;
}

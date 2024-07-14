package com.moviebooking.movie.dto.hall;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaResponse {
    private Long cinemaId;
    private String name;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
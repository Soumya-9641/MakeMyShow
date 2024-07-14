package com.moviebooking.movie.dto.seat;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponseDTO {
    private Long id;
    private Integer seatNumber;
    private String type;
    private String hallType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long hallId;
    private String hallName;
}

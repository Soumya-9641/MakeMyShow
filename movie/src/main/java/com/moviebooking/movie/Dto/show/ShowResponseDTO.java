package com.moviebooking.movie.dto.show;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowResponseDTO {
    private Long showId;
    private Long movieId;
    private Long hallId;
    private String startTime;
    private String endTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

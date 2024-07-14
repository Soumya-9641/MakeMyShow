package com.moviebooking.movie.dto.hall;

import java.time.LocalDateTime;
import java.util.Set;

import com.moviebooking.movie.dto.halltype.HallTypeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HallResponseDto {
    private Long hallId;
    private String hallName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<HallTypeResponse> hallTypes;
}

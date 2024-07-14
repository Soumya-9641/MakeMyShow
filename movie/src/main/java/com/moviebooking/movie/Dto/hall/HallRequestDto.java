package com.moviebooking.movie.dto.hall;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HallRequestDto {
    private String hallName;
    private Set<Long> hallTypeIds;
}

package com.moviebooking.movie.dto.show;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowDTO {
    private Long movieId;
    private Long hallId;
    private String startTime;
    private String endTime;
}
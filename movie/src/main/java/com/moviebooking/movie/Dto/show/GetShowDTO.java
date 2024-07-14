package com.moviebooking.movie.dto.show;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetShowDTO {
    private Long showId;
    private String startTime;
    private String endTime;
    private String createdAt;
    private String updatedAt;
    private MovieDTO movie;
    private HallDTO hall;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MovieDTO {
        private Long movieId;
        private String movieName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HallDTO {
        private Long hallId;
        private String hallName;
    }
}

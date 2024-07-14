package com.moviebooking.movie.dto.cinema;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CinemaRequestDto {
    private String name;
    private String location;
    private List<Long> hallIds;
}

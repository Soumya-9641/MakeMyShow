package com.moviebooking.movie.dto.movie;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private Long movie_id;
    private String description;
    private String duration;
    private String trailerLink;
    private Integer likesCount;
    private Integer viewsCount;
    private Set<String> languages;
    private Set<String> hallTypes;
    private Set<String> castName;
}

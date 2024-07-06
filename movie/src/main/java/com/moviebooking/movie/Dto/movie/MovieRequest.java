package com.moviebooking.movie.dto.movie;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

    private String title;
    private String description;
    private String duration;
    private String trailerLink;
    private Integer likesCount;
    private Integer viewsCount;
    private String releaseDate;
    private Set<Long> languageIds;
    private Set<Long> hallTypeIds;
    private Set<Long> castIds;

}

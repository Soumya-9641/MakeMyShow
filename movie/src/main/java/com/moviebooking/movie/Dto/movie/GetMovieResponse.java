package com.moviebooking.movie.dto.movie;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMovieResponse {

    private Long movieId;
    private String title;
    private String description;
    private String duration;
    private String releaseDate;
    private String trailerLink;
    private Integer viewsCount;
    private Integer likesCount;

    private Set<LanguageDto> languages;
    private Set<HallTypeDto> hallTypes;
    private Set<ReviewsDto> reviews;
    private Set<CastDto> casts;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LanguageDto {
        private Long languageId;
        private String languageName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HallTypeDto {
        private Long hallTypeId;
        private String hallTypeName;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewsDto {
        private Integer userId;
        private String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CastDto {
        private Long castId;
        private String castName;
        private String famousAs;
    }

}

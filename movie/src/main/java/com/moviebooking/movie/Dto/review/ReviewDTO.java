package com.moviebooking.movie.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Integer userId;
    private String content;
}

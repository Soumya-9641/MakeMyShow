package com.moviebooking.movie.dto.language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponse {
    private Long languageId;
    private String languageName;
}

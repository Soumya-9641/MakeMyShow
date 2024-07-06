package com.moviebooking.movie.service.language;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.language.LanguageRequest;
import com.moviebooking.movie.dto.language.LanguageResponse;

@Service
public interface languageService {
    LanguageResponse createLanguage(LanguageRequest request);

    List<LanguageResponse> getLanguage();
}

package com.moviebooking.movie.service.language;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.language.LanguageRequest;
import com.moviebooking.movie.dto.language.LanguageResponse;
import com.moviebooking.movie.model.Language;
import com.moviebooking.movie.repository.languagerepo.LanguageRepository;

@Service
public class LanguageServiceImpl implements languageService {
    @Autowired
    private LanguageRepository languagerepo;

    @Override
    public LanguageResponse createLanguage(LanguageRequest request) {
        Language lang = new Language();
        lang.setLanguageName(request.getLanguageName());
        Language saveLang = languagerepo.save(lang);
        LanguageResponse response = new LanguageResponse();
        response.setLanguageId(saveLang.getLanguageId());
        response.setLanguageName(saveLang.getLanguageName());
        return response;
    }

    @Override
    public List<LanguageResponse> getLanguage() {

        List<Language> languages = languagerepo.findAll();
        return languages.stream()
                .map(language -> new LanguageResponse(language.getLanguageId(), language.getLanguageName()))
                .collect(Collectors.toList());
    }
}

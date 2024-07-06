package com.moviebooking.movie.controller.languagecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.language.LanguageRequest;
import com.moviebooking.movie.dto.language.LanguageResponse;
import com.moviebooking.movie.service.language.languageService;

@RestController
@RequestMapping("/api/language")
public class languageController {
    @Autowired
    private languageService languageservice;

    @PostMapping
    public ResponseEntity<LanguageResponse> createLanguage(@RequestBody LanguageRequest request) {
        LanguageResponse response = languageservice.createLanguage(request);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<LanguageResponse>> getLanguages() {
        List<LanguageResponse> response = languageservice.getLanguage();
        return ResponseEntity.ok(response);
    }

}

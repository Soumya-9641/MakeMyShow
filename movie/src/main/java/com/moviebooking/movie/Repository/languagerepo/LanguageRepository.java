package com.moviebooking.movie.repository.languagerepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviebooking.movie.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}

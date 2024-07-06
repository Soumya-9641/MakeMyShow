package com.moviebooking.movie.service.movie;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.movie.GetMovieResponse;
import com.moviebooking.movie.dto.movie.MovieRequest;
import com.moviebooking.movie.dto.movie.MovieResponse;
import com.moviebooking.movie.model.Cast;
import com.moviebooking.movie.model.HallType;
import com.moviebooking.movie.model.Language;
import com.moviebooking.movie.model.Movie;
import com.moviebooking.movie.repository.castcrew.CastRepo;
import com.moviebooking.movie.repository.hallrepo.HallTypeRepository;
import com.moviebooking.movie.repository.languagerepo.LanguageRepository;
import com.moviebooking.movie.repository.movie.MovieRepository;

import jakarta.transaction.Transactional;

@Service
public class MovieServiceImpl implements MovieService {

        @Autowired
        private MovieRepository movieRepo;

        @Autowired
        private LanguageRepository langRepo;

        @Autowired
        private HallTypeRepository halltypeRepo;
        @Autowired
        private CastRepo castrepo;

        @Override
        public MovieResponse createMovie(MovieRequest request) {

                Movie movie = new Movie();
                movie.setTitle(request.getTitle());
                movie.setDescription(request.getDescription());
                movie.setDuration(request.getDuration());
                movie.setLikesCount(request.getLikesCount());
                movie.setViewsCount(request.getViewsCount());
                movie.setTrailerLink(request.getTrailerLink());
                movie.setReleaseDate(request.getReleaseDate());

                Set<Language> languages = new HashSet<>();
                for (Long languageId : request.getLanguageIds()) {
                        Optional<Language> optionalLanguage = langRepo.findById(languageId);
                        optionalLanguage.ifPresent(languages::add);
                }
                movie.setLanguages(languages);

                Set<HallType> hallTypes = new HashSet<>();
                for (Long hallTypeId : request.getHallTypeIds()) {
                        Optional<HallType> optionalHallType = halltypeRepo.findById(hallTypeId);
                        optionalHallType.ifPresent(hallTypes::add);
                }
                movie.setHallTypes(hallTypes);
                Set<Cast> casts = new HashSet<>();
                for (Long castId : request.getCastIds()) {
                        Optional<Cast> OptionalCast = castrepo.findById(castId);
                        OptionalCast.ifPresent(casts::add);
                }

                movie.setCast(casts);

                Movie savedMovie = movieRepo.save(movie);

                // Since the movie object returned by the save method might not have the
                // lazy-loaded associations initialized,
                // we should fetch the saved movie again to ensure all associations are loaded.
                Movie fetchedMovie = movieRepo.findById(savedMovie.getMovie_id())
                                .orElseThrow(() -> new RuntimeException(
                                                "Movie not found after saving with id: " + savedMovie.getMovie_id()));
                System.out.println(fetchedMovie.getLanguages());
                MovieResponse response = new MovieResponse();
                response.setDescription(fetchedMovie.getDescription());
                response.setDuration(fetchedMovie.getDuration());
                response.setLikesCount(fetchedMovie.getLikesCount());
                response.setTrailerLink(fetchedMovie.getTrailerLink());
                response.setMovie_id(fetchedMovie.getMovie_id());
                response.setViewsCount(fetchedMovie.getViewsCount());
                response.setLanguages(fetchedMovie.getLanguages().stream().map(Language::getLanguageName)
                                .collect(Collectors.toSet()));
                response.setHallTypes(fetchedMovie.getHallTypes().stream().map(HallType::getHallTypeName)
                                .collect(Collectors.toSet()));
                response.setCastName(
                                fetchedMovie.getCast().stream().map(Cast::getCastName).collect(Collectors.toSet()));
                return response;
        }

        @Override
        @Transactional
        public GetMovieResponse getMovie(Long movieId) {

                Optional<Movie> optionalMovie = movieRepo.findById(movieId);
                if (!optionalMovie.isPresent()) {
                        throw new RuntimeException("Movie not found with id: " + movieId);
                }

                Movie movie = optionalMovie.get();
                GetMovieResponse response = new GetMovieResponse();

                response.setMovieId(movie.getMovie_id());
                response.setTitle(movie.getTitle());
                response.setDescription(movie.getDescription());
                response.setDuration(movie.getDuration());
                response.setReleaseDate(movie.getReleaseDate());
                response.setTrailerLink(movie.getTrailerLink());
                response.setViewsCount(movie.getViewsCount());
                response.setLikesCount(movie.getLikesCount());
                response.setLanguages(movie.getLanguages().stream()
                                .map(language -> new GetMovieResponse.LanguageDto(language.getLanguageId(),
                                                language.getLanguageName()))
                                .collect(Collectors.toSet()));
                response.setHallTypes(movie.getHallTypes().stream()
                                .map(hallType -> new GetMovieResponse.HallTypeDto(hallType.getHallTypeId(),
                                                hallType.getHallTypeName()))
                                .collect(Collectors.toSet()));
                response.setReviews(movie.getReviews().stream()
                                .map(review -> new GetMovieResponse.ReviewsDto(review.getUserId(), review.getContent()))
                                .collect(Collectors.toSet()));
                response.setCasts(movie.getCast().stream()
                                .map(cast -> new GetMovieResponse.CastDto(cast.getCastId(), cast.getCastName(),
                                                cast.getFamousAs()))
                                .collect(Collectors.toSet()));
                return response;

        }

}

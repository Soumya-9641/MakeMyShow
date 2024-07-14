package com.moviebooking.movie.service.cinema;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.show.GetShowDTO;
import com.moviebooking.movie.dto.show.ShowDTO;
import com.moviebooking.movie.dto.show.ShowResponseDTO;
import com.moviebooking.movie.model.Hall;
import com.moviebooking.movie.model.Movie;
import com.moviebooking.movie.model.Show;
import com.moviebooking.movie.repository.cinema.ShowRepository;
import com.moviebooking.movie.repository.hall.HallRepository;
import com.moviebooking.movie.repository.movie.MovieRepository;

@Service
public class ShowService {
        @Autowired
        private HallRepository hallRepository;
        @Autowired
        private MovieRepository movieRepository;
        @Autowired
        private ShowRepository showRepository;

        public ShowResponseDTO createShow(ShowDTO showDTO) {
                Movie movie = movieRepository.findById(showDTO.getMovieId())
                                .orElseThrow(() -> new RuntimeException(
                                                "Movie not found with id: " + showDTO.getMovieId()));

                Hall hall = hallRepository.findById(showDTO.getHallId())
                                .orElseThrow(() -> new RuntimeException(
                                                "Hall not found with id: " + showDTO.getHallId()));

                Show show = new Show();
                show.setMovie(movie);
                show.setHall(hall);
                show.setStartTime(showDTO.getStartTime());
                show.setEndTime(showDTO.getEndTime());
                show.setCreatedAt(LocalDateTime.now());
                show.setUpdatedAt(LocalDateTime.now());

                Show savedShow = showRepository.save(show);

                return new ShowResponseDTO(
                                savedShow.getShowId(),
                                savedShow.getMovie().getMovie_id(),
                                savedShow.getHall().getHallId(),
                                savedShow.getStartTime(),
                                savedShow.getEndTime(),
                                savedShow.getCreatedAt(),
                                savedShow.getUpdatedAt());
        }

        public GetShowDTO getShow(Long showId) {
                Optional<Show> showOptional = showRepository.findById(showId);

                if (showOptional.isPresent()) {
                        Show show = showOptional.get();
                        GetShowDTO.MovieDTO movieDTO = new GetShowDTO.MovieDTO(
                                        show.getMovie().getMovie_id(),
                                        show.getMovie().getTitle());

                        GetShowDTO.HallDTO hallDTO = new GetShowDTO.HallDTO(
                                        show.getHall().getHallId(),
                                        show.getHall().getHallName());

                        GetShowDTO showResponseDTO = new GetShowDTO(
                                        show.getShowId(),
                                        show.getStartTime(),
                                        show.getEndTime(),
                                        show.getCreatedAt().toString(),
                                        show.getUpdatedAt().toString(),
                                        movieDTO,
                                        hallDTO);

                        return showResponseDTO;
                } else {
                        throw new RuntimeException("Show not found with id: " + showId);
                }
        }
}

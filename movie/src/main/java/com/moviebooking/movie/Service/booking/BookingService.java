package com.moviebooking.movie.service.booking;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.booking.BookingDetailsRequestDTO;
import com.moviebooking.movie.dto.booking.BookingDetailsResponseDTO;
import com.moviebooking.movie.dto.booking.BookingDetailsResponseDTO.BookingDto;
import com.moviebooking.movie.dto.booking.BookingDetailsResponseDTO.SeatDto;
import com.moviebooking.movie.dto.booking.BookingRequestDTO;
import com.moviebooking.movie.dto.booking.BookingResponseDTO;
import com.moviebooking.movie.model.Booking;
import com.moviebooking.movie.model.BookingDetails;
import com.moviebooking.movie.model.Seat;
import com.moviebooking.movie.model.Show;
import com.moviebooking.movie.model.User;
import com.moviebooking.movie.repository.booking.BookingDetailsRepository;
import com.moviebooking.movie.repository.booking.BookingRepository;
import com.moviebooking.movie.repository.cinema.ShowRepository;
import com.moviebooking.movie.repository.hall.SeatRepository;
import com.moviebooking.movie.repository.user.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;
    @Autowired
    private SeatRepository seatRepository;

    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {
        Optional<Show> showOptional = showRepository.findById(bookingRequestDTO.getShowId());
        Optional<User> userOptional = userRepository.findById(bookingRequestDTO.getUserId());

        if (showOptional.isPresent() && userOptional.isPresent()) {
            Show show = showOptional.get();
            User user = userOptional.get();

            Booking booking = new Booking();
            booking.setBookingTime(bookingRequestDTO.getBookingTime());
            booking.setTotalAmount(bookingRequestDTO.getTotalAmount());
            booking.setStatus(bookingRequestDTO.getStatus());
            booking.setShow(show);
            booking.setUser(user);
            booking.setCreatedAt(LocalDateTime.now());
            booking.setUpdatedAt(LocalDateTime.now());

            Booking savedBooking = bookingRepository.save(booking);

            return new BookingResponseDTO(
                    savedBooking.getBookingId(),
                    savedBooking.getBookingTime(),
                    savedBooking.getTotalAmount(),
                    savedBooking.getStatus(),
                    savedBooking.getCreatedAt(),
                    savedBooking.getUpdatedAt(),
                    show.getShowId(),
                    show.getHall().getHallName(), // Assuming Show has a hall with a name
                    user.getUserId(),
                    user.getName() // Assuming User has a name
            );
        } else {
            throw new RuntimeException("Show or User not found");
        }
    }

    public BookingResponseDTO getBooking(Long id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);

        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            Show show = booking.getShow();
            User user = booking.getUser();

            return new BookingResponseDTO(
                    booking.getBookingId(),
                    booking.getBookingTime(),
                    booking.getTotalAmount(),
                    booking.getStatus(),
                    booking.getCreatedAt(),
                    booking.getUpdatedAt(),
                    show.getShowId(),
                    show.getHall().getHallName(), // Assuming Show has a hall with a name
                    user.getUserId(),
                    user.getName() // Assuming User has a name
            );
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

    @Transactional
    public BookingDetailsResponseDTO createBookingDetails(BookingDetailsRequestDTO request) {
        Seat seat = seatRepository.findById(request.getSeatId())
                .orElseThrow(() -> new RuntimeException("Seat not found with id: " + request.getSeatId()));
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + request.getBookingId()));

        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setPrice(request.getPrice());
        bookingDetails.setCreatedAt(LocalDateTime.now());
        bookingDetails.setUpdatedAt(LocalDateTime.now());
        bookingDetails.setSeat(seat);
        bookingDetails.setBooking(booking);

        bookingDetails = bookingDetailsRepository.save(bookingDetails);

        BookingDetailsResponseDTO response = new BookingDetailsResponseDTO();
        response.setBookingDetailsId(bookingDetails.getId());
        response.setPrice(bookingDetails.getPrice());
        response.setCreatedAt(bookingDetails.getCreatedAt().toString());
        response.setUpdatedAt(bookingDetails.getUpdatedAt().toString());

        SeatDto seatDto = new SeatDto();
        seatDto.setSeatId(seat.getId());
        seatDto.setSeatNumber(seat.getSeatNumber());
        seatDto.setSeatType(seat.getType());
        seatDto.setHallId(seat.getHall().getHallId());
        response.setSeat(seatDto);

        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setUserId(booking.getUser().getUserId());
        bookingDto.setBookingTime(booking.getBookingTime());
        response.setBooking(bookingDto);

        return response;
    }

    @Transactional
    public BookingDetailsResponseDTO getBookingDetails(Long bookingDetailsId) {
        BookingDetails bookingDetails = bookingDetailsRepository.findById(bookingDetailsId)
                .orElseThrow(() -> new RuntimeException("BookingDetails not found with id: " + bookingDetailsId));

        BookingDetailsResponseDTO response = new BookingDetailsResponseDTO();
        response.setBookingDetailsId(bookingDetails.getId());
        response.setPrice(bookingDetails.getPrice());
        response.setCreatedAt(bookingDetails.getCreatedAt().toString());
        response.setUpdatedAt(bookingDetails.getUpdatedAt().toString());

        Seat seat = bookingDetails.getSeat();
        SeatDto seatDto = new SeatDto();
        seatDto.setSeatId(seat.getId());
        seatDto.setSeatNumber(seat.getSeatNumber());
        seatDto.setSeatType(seat.getType());
        seatDto.setHallId(seat.getHall().getHallId());
        response.setSeat(seatDto);

        Booking booking = bookingDetails.getBooking();
        BookingDto bookingDto = new BookingDto();
        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setUserId(booking.getUser().getUserId());
        bookingDto.setBookingTime(booking.getBookingTime());
        response.setBooking(bookingDto);

        return response;
    }
}

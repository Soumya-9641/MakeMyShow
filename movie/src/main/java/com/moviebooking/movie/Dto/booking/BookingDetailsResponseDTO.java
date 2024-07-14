package com.moviebooking.movie.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookingDetailsResponseDTO {
    private Long bookingDetailsId;
    private String price;
    private String createdAt;
    private String updatedAt;
    private SeatDto seat;
    private BookingDto booking;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SeatDto {
        private Long seatId;
        private Integer seatNumber;
        private String seatType;
        private Long hallId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookingDto {
        private Long bookingId;
        private Long userId;
        private String bookingTime;

    }
}

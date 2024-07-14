package com.moviebooking.movie.dto.booking;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDTO {
    private Long bookingId;
    private String bookingTime;
    private Integer totalAmount;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long showId;
    private String showName; // Assuming Show has a name field
    private Long userId;
    private String userName;
}

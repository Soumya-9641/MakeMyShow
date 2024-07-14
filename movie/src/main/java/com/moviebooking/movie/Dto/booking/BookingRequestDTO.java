package com.moviebooking.movie.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO {
    private String bookingTime;
    private Integer totalAmount;
    private String status;
    private Long showId;
    private Long userId;
}

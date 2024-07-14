package com.moviebooking.movie.dto.booking;

import java.time.LocalDateTime;

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
public class BookingDetailsRequestDTO {
    private String price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long seatId;
    private Long bookingId;

}

package com.moviebooking.movie.dto.seat;

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
public class SeatRequestDTO {
    private Integer seatNumber;
    private String type;
    private String hallType;
    private Long hallId;
}

package com.moviebooking.movie.dto.halltype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HallTypeResponse {
    private Long hallTypeId;
    private String hallTypeName;
}

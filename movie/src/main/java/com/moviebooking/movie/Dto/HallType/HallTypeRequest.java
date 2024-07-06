package com.moviebooking.movie.dto.halltype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HallTypeRequest {
    private String hallTypeName;
}

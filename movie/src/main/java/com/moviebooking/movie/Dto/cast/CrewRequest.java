package com.moviebooking.movie.dto.cast;

import java.util.List;

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
public class CrewRequest {

    private String crewName;
    private String famousAs;
    private String details;
    private String dob;
    private List<String> industries;
}

package com.moviebooking.movie.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}

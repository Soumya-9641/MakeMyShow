package com.moviebooking.movie.service.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.user.UserRequestDTO;
import com.moviebooking.movie.model.User;
import com.moviebooking.movie.repository.user.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;

    public User createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhoneNumber(userRequestDTO.getPhoneNumber());
        user.setPassword(userRequestDTO.getPassword()); // Set a default or generated password if necessary
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userrepository.save(user);
    }

}

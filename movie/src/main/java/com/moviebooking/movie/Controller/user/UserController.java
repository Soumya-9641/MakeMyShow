package com.moviebooking.movie.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.user.UserRequestDTO;
import com.moviebooking.movie.model.User;
import com.moviebooking.movie.service.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userservice;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userservice.createUser(userRequestDTO);
        return ResponseEntity.ok("User created successfully with ID: " + user.getUserId());
    }
}

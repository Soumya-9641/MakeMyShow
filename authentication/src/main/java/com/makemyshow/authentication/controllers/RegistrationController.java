package com.makemyshow.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makemyshow.authentication.dto.UserRequestDTO;
import com.makemyshow.authentication.event.RegistrationCompleteEvent;
import com.makemyshow.authentication.models.User;
import com.makemyshow.authentication.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/testing")
    public String hello() {
        return "hello";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequestDTO userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)));
        return "Success";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }
}

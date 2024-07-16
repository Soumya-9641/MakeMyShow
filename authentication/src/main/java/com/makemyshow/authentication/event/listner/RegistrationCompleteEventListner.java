package com.makemyshow.authentication.event.listner;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.makemyshow.authentication.event.RegistrationCompleteEvent;
import com.makemyshow.authentication.models.User;
import com.makemyshow.authentication.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListner implements
        ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        String url = event.getApplicationUrl()
                + "/verifyRegistration?token="
                + token;
        log.info("Click the link to verify your account: {}",
                url);

    }

}

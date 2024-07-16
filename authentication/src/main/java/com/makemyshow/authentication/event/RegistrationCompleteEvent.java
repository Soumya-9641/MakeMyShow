package com.makemyshow.authentication.event;

import org.springframework.context.ApplicationEvent;

import com.makemyshow.authentication.models.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private final User user;
    private final String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}

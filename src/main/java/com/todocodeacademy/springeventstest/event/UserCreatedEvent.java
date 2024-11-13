package com.todocodeacademy.springeventstest.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
// Definir la información que contendrá el evento y extender la clase a ApplicationEvent
public class UserCreatedEvent extends ApplicationEvent {
    private String userEmail;
    private String userPhoneNumber;

    public UserCreatedEvent(Object source, String userEmail, String userPhoneNumber) {
        super(source);
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }
}

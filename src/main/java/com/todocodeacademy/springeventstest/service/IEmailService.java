package com.todocodeacademy.springeventstest.service;

import com.todocodeacademy.springeventstest.event.UserCreatedEvent;

public interface IEmailService {
    void sendEmail(UserCreatedEvent userCreatedEvent);
}

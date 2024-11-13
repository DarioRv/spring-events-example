package com.todocodeacademy.springeventstest.service;

import com.todocodeacademy.springeventstest.event.UserCreatedEvent;

public interface ISMSService {
    void sendSMS(UserCreatedEvent userCreatedEvent);
}

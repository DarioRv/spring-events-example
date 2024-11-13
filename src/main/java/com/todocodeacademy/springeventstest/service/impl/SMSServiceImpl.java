package com.todocodeacademy.springeventstest.service.impl;

import com.todocodeacademy.springeventstest.event.UserCreatedEvent;
import com.todocodeacademy.springeventstest.service.ISMSService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements ISMSService {
//  Indicar con el decorador que el método estara escuchando el evento que esta en los argumentos
    @EventListener
    @Override
    public void sendSMS(UserCreatedEvent userCreatedEvent) {
//      User la información del evento como consideremos
        System.out.println("Sending SMS to " + userCreatedEvent.getUserPhoneNumber());
    }
}

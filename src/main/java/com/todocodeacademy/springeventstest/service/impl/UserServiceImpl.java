package com.todocodeacademy.springeventstest.service.impl;

import com.todocodeacademy.springeventstest.dto.CreateUserDto;
import com.todocodeacademy.springeventstest.event.UserCreatedEvent;
import com.todocodeacademy.springeventstest.service.IEmailService;
import com.todocodeacademy.springeventstest.service.ISMSService;
import com.todocodeacademy.springeventstest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
//    @Autowired
//    private IEmailService emailService;
//    @Autowired
//    private ISMSService smsService;

//  Inyectar el EventPublisher para publicar eventos que ocurren en nuestro código
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public String createUser(CreateUserDto createUserDto) {
        System.out.println("Creating user");
//      Código acoplado, mejor usar eventos
//      emailService.sendEmail(createUserDto.getEmail());
//      smsService.sendSMS(createUserDto.getPhoneNumber());

//      Publicar el evento UserCreated para los listeners pasando por argumento nuestro evento que hemos creado
        eventPublisher.publishEvent(
                new UserCreatedEvent(this, createUserDto.getEmail(), createUserDto.getPhoneNumber())
        );

        System.out.println("User created successfully");
        return "User created successfully";
    }
}

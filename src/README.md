# Eventos en Spring Boot

Los **eventos** en `Spring Boot` permiten la comunicación entre componentes de la aplicación de una 
**manera desacoplada**. Un `evento` es un objeto que encapsula la información relevante de un suceso en la aplicación. 
Un `listener` es un componente que escucha los eventos y ejecuta una acción cuando un evento es lanzado.
Un `publisher` es un componente que lanza un evento.

En `Spring Boot`, los eventos son lanzados por un `ApplicationEventPublisher` y son escuchados por un `EventListener`.
Un `ApplicationEvent` es un objeto que representa un
evento. Un `EventListener` es un método anotado con `@EventListener` que escucha un evento específico.

## Introducción

En este proyecto se muestra como se pueden crear eventos en Spring Boot. Se creará un evento que se lanzará cuando
un usuario se registre en la aplicación. Este evento será escuchado por dos listeners que se encargarán de enviar un 
correo de bienvenida al usuario y un SMS.

## Servicios

- User Service: Servicio que se encarga de registrar a un usuario en la aplicación.
- Email Service: Servicio que se encarga de enviar correos electrónicos.
- Sms Service: Servicio que se encarga de enviar mensajes de texto.

## Creación del evento

Para crear un evento en Spring Boot, se debe crear una clase que extienda de `ApplicationEvent`. En este caso, se ha
creado la clase `UserCreatedEvent` que representa el evento de registro de un usuario.

```java
@Getter
@Setter
public class UserCreatedEvent extends ApplicationEvent {
    private String userEmail;
    private String userPhoneNumber;

    public UserCreatedEvent(Object source, String userEmail, String userPhoneNumber) {
        super(source);
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }
}

```

## Creación de los listeners

Para crear un listener en Spring Boot, se debe crear una clase que contenga un método anotado con `@EventListener`. En
este caso, se han creado dos clases que representan los listeners `EmailListener` y `SmsListener`.

```java
@EventListener
public void sendEmail(UserCreatedEvent userCreatedEvent) {
    System.out.println("Sending email to " + userCreatedEvent.getUserEmail());
}
```
    
```java
@EventListener
public void sendSMS(UserCreatedEvent userCreatedEvent) {
    System.out.println("Sending SMS to " + userCreatedEvent.getUserPhoneNumber());
}
```

## Lanzamiento del evento

Para lanzar un evento en Spring Boot, se debe inyectar un objeto de tipo `ApplicationEventPublisher` y llamar al método
`publishEvent` pasando como argumento una instancia del evento que se quiere lanzar.

```java
@Autowired
private ApplicationEventPublisher eventPublisher;

public String createUser(CreateUserDto createUserDto) {
    System.out.println("Creating user");
    eventPublisher.publishEvent(
            new UserCreatedEvent(this, createUserDto.getEmail(), createUserDto.getPhoneNumber())
    );
    return "User created successfully";
}
```

## Ejecución

Para ejecutar la aplicación, se debe ejecutar el comando `mvn spring-boot:run`. Una vez que la aplicación esté en
ejecución, se puede probar el funcionamiento de los eventos lanzando una petición POST a `http://localhost:8080/users`
con el siguiente cuerpo:

```json
{
    "username": "Example",
    "password": "123456",
    "email": "example@mail.com",
    "phoneNumber": "123456789"
}
```

## Resultado

Al lanzar la petición POST, se debería ver en la consola el mensaje `Creating user`, `Sending email to example@mail.com
` y `Sending SMS to 123456789`.

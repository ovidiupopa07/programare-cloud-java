package com.eureka.persons;

import org.springframework.http.HttpStatus;

public class PersonsException extends RuntimeException{
    private HttpStatus status;

    public PersonsException(String message) {
        super(message);
        this.status = status;
    }

    public PersonsException(HttpStatus status, Throwable cause) {
        super(cause);
        this.status = status;
    }
}

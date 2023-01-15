package com.neff.exceptions;

public class UserErrorException extends RuntimeException{

    public UserErrorException(String message) {
        super(message);
    }
}

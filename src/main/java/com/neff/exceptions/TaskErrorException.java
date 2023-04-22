package com.neff.exceptions;

public class TaskErrorException extends RuntimeException{

    public TaskErrorException(String message) {
        super(message);
    }
}

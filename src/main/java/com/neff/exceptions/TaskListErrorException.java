package com.neff.exceptions;

public class TaskListErrorException extends RuntimeException{

    public TaskListErrorException(String message) {
        super(message);
    }
}

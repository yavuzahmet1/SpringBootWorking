package com.trial.spring.advice;

public class UserNotFound extends RuntimeException{
    private static final long seralVersionUID=1L;

    public UserNotFound(String message){
        super(message);
    }
}

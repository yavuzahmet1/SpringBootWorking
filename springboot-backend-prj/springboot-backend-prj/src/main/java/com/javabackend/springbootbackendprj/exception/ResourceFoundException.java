package com.javabackend.springbootbackendprj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class ResourceFoundException extends RuntimeException{
    private static final Long serialVersionUID=1L;

    public ResourceFoundException(String mmessage){
        super(mmessage);
    }
}
//24.00dakikada kaldım
//https://www.youtube.com/watch?v=XkVpb_8IPUM
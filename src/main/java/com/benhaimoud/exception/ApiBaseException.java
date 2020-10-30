package com.benhaimoud.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @Created on 11/10/2020.
 */
public abstract class ApiBaseException extends RuntimeException{
    public ApiBaseException(String message) {
        super(message);
    }
    public abstract HttpStatus getStatusCode();
}

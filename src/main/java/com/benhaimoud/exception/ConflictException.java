package com.benhaimoud.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @Created on 11/10/2020.
 */
public class ConflictException extends ApiBaseException{

    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}

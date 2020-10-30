package com.benhaimoud.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @Created on 11/10/2020.
 */
public class NotFoundException extends  ApiBaseException {

    public NotFoundException(String message) {
        super(message);
    }
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}

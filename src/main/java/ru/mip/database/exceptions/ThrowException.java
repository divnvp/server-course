package ru.mip.database.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ThrowException extends RuntimeException{
    public ThrowException(String s) {
        super(s);
    }
}

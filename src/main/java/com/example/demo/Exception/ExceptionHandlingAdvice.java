package com.example.demo.Exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionHandlingAdvice {
    private final Logger log = Logger.getLogger(ExceptionHandlingAdvice.class);

    public ExceptionHandlingAdvice() {
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleBadRequestException(UserExceptions.RestException e) {
        log.error("Error: " + e.getMessage());
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getLocalizedMessage(), getStackTrace(e));
    }

    private <T extends Exception>String getStackTrace(T exception) {
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for(int i = 0; i < 5; i++) {
            stringBuilder.append(stackTrace[i]).append(" \n");
        }
        return stringBuilder.toString();
    }
}

package com.dayliv.dayliv.exception;

public class ErrorHandlerException  extends RuntimeException{
    public ErrorHandlerException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public ErrorHandlerException(String exMessage) {
        super(exMessage);
    }
}

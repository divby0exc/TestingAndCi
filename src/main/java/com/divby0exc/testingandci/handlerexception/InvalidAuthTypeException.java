package com.divby0exc.testingandci.handlerexception;

public class InvalidAuthTypeException extends Exception {
    public InvalidAuthTypeException(String errorMsg) {
        super(errorMsg);
    }
}

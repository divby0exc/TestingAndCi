package com.divby0exc.testingandci.handlerexception;

public class InvalidAccountIdException extends Exception {
    public InvalidAccountIdException(String errorMsg) {
        super(errorMsg);
    }
}

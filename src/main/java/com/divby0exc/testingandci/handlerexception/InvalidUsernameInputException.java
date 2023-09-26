package com.divby0exc.testingandci.handlerexception;

public class InvalidUsernameInputException extends Exception {
    public InvalidUsernameInputException(String errorMsg) {
        super(errorMsg);
    }
}

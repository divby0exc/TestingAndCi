package com.divby0exc.testingandci.handlerexception;

public class InvalidDeparturePointInputException extends Exception {
    public InvalidDeparturePointInputException(String errorMsg) {
        super(errorMsg);
    }
}

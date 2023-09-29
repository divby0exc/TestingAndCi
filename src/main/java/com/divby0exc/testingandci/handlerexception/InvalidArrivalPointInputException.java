package com.divby0exc.testingandci.handlerexception;

public class InvalidArrivalPointInputException extends Exception {
    public InvalidArrivalPointInputException(String errorMsg) {
        super(errorMsg);
    }
}

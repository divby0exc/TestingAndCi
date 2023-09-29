package com.divby0exc.testingandci.handlerexception;

public class InvalidEstimatedDepartureInputException extends Exception {
    public InvalidEstimatedDepartureInputException(String errorMsg) {
        super(errorMsg);
    }
}

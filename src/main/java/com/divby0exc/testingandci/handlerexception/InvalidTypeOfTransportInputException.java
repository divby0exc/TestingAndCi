package com.divby0exc.testingandci.handlerexception;

public class InvalidTypeOfTransportInputException extends Exception {
    public InvalidTypeOfTransportInputException(String errorMsg) {
        super(errorMsg);
    }
}

package com.divby0exc.testingandci.handlerexception;

public class InvalidBookingIdException extends Exception {
    public InvalidBookingIdException(String errorMsg) {
        super(errorMsg);
    }
}

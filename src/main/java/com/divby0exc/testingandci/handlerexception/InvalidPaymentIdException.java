package com.divby0exc.testingandci.handlerexception;

public class InvalidPaymentIdException extends Exception {
    public InvalidPaymentIdException(String errorMsg) {
        super(errorMsg);
    }
}

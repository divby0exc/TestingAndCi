package com.divby0exc.testingandci.handlerexception;

public class InvalidPaymentInfoException extends Exception {
    public InvalidPaymentInfoException(String errorMsg) {
        super(errorMsg);
    }
}

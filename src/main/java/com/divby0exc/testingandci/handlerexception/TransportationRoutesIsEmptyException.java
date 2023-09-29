package com.divby0exc.testingandci.handlerexception;

public class TransportationRoutesIsEmptyException extends Exception {
    public TransportationRoutesIsEmptyException(String errorMsg) {
        super(errorMsg);
    }
}

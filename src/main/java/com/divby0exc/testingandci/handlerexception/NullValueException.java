package com.divby0exc.testingandci.handlerexception;

public class NullValueException extends Exception {
    public NullValueException(String errorMsg) {
        super(errorMsg);
    }
}

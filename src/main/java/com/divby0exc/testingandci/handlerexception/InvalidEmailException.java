package com.divby0exc.testingandci.handlerexception;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String errorMsg) {
        super(errorMsg);
    }

}

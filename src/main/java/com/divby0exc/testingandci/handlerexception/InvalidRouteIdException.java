package com.divby0exc.testingandci.handlerexception;

public class InvalidRouteIdException extends Exception {
    public InvalidRouteIdException(String errorMsg) {
        super(errorMsg);
    }
}

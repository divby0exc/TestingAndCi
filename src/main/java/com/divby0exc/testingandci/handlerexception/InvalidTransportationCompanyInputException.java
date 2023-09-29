package com.divby0exc.testingandci.handlerexception;

public class InvalidTransportationCompanyInputException extends Exception {
    public InvalidTransportationCompanyInputException(String errorMsg) {
        super(errorMsg);
    }
}

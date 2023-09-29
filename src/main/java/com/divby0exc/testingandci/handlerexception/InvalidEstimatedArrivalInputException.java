package com.divby0exc.testingandci.handlerexception;

public class InvalidEstimatedArrivalInputException extends Exception {
    public InvalidEstimatedArrivalInputException(String errorMsg) {
        super(errorMsg);
    }
}

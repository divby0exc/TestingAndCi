package com.divby0exc.testingandci.handlerexception;

public class InvalidTicketPriceInputException extends Exception {
    public InvalidTicketPriceInputException(String errorMsg) {
        super(errorMsg);
    }
}

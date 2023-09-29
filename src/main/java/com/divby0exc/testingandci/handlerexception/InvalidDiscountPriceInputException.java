package com.divby0exc.testingandci.handlerexception;

public class InvalidDiscountPriceInputException extends Exception {
    public InvalidDiscountPriceInputException(String errorMsg) {
        super(errorMsg);
    }
}

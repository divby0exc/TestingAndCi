package com.divby0exc.testingandci.handlerexception;

import java.nio.file.InvalidPathException;
import java.util.concurrent.ExecutionException;

public class InvalidPaymentInfoException extends Exception {
    public InvalidPaymentInfoException(String errorMsg) {
        super(errorMsg);
    }
}

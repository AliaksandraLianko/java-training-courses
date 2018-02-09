package com.company.exceptions;

public class SmallAwardAmountException extends Exception {
    public SmallAwardAmountException() {
    }

    public SmallAwardAmountException(String message) {
        super(message);
    }

    public SmallAwardAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public SmallAwardAmountException(Throwable cause) {
        super(cause);
    }

    public SmallAwardAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.mirror.exceptions;

public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(String message) {
        super(message);
    }

    public MoneyNotEnoughException() {
    }
}

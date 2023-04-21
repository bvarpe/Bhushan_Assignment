package com.example.crudoperations.exceptions;
public class DealException extends RuntimeException {
    public DealException(String message ,String dealNumber) {
        super(message+dealNumber);
    }
}

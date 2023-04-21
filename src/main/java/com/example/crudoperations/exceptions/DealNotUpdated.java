package com.example.crudoperations.exceptions;

public class DealNotUpdated extends RuntimeException{
    public DealNotUpdated(String message ,String dealNumber) {
        super(message+dealNumber);
    }
}

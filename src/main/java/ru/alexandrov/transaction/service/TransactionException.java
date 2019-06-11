package ru.alexandrov.transaction.service;

public class TransactionException extends Exception {
    private String message;
    public TransactionException (String message){
        super(message);
    }
}

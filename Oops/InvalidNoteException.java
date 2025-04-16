package com.example;
public class InvalidNoteException extends Exception {
    public InvalidNoteException(String message) {
        super(message);
    }
}
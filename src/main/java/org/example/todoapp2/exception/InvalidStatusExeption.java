package org.example.todoapp2.exception;

public class InvalidStatusExeption extends  RuntimeException {
    public InvalidStatusExeption(String message) {
        super(message);
    }
}

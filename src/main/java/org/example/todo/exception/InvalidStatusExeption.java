package org.example.todo.exception;

public class InvalidStatusExeption extends  RuntimeException {
    public InvalidStatusExeption(String message) {
        super(message);
    }
}

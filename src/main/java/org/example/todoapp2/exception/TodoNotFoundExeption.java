package org.example.todoapp2.exception;

public class TodoNotFoundExeption extends RuntimeException {
    public TodoNotFoundExeption(String message) {
        super(message);
    }
}

package org.example.todo.exception;

public class TodoNotFoundExeption extends RuntimeException {
    public TodoNotFoundExeption(String message) {
        super(message);
    }
}

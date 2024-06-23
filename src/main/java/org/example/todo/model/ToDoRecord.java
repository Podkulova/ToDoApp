package org.example.todo.model;

import java.time.LocalDate;

public record ToDoRecord(String name, LocalDate deadline) {
}

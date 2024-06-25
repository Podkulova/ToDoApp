package org.example.todoapp2.model;

import java.time.LocalDate;

public record ToDoRecord(String name, LocalDate deadline) {
}

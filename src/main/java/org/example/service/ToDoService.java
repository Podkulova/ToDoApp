package org.example.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ToDoService {
    void createToDo(String nameDescription, LocalDate deadLine);
}

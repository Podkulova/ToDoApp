package org.example.todo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ToDoService {
     void createToDo(String name, LocalDate deadLine);

}

package org.example.todoapp2.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ToDoService {
     void createToDo(String name, LocalDate deadLine);

}

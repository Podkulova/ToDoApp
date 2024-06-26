package org.example.todoapp2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.todoapp2.model.ToDo;
import org.example.todoapp2.model.ToDoRecord;
import org.example.todoapp2.service.implementation.ToDoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class RestController {

    private final ToDoServiceImpl toDoService;

    @PostMapping("/createToDo")
    public ResponseEntity<String> createToDo(@RequestBody ToDoRecord toDoRecord) {
        toDoService.createToDo(toDoRecord.name(), toDoRecord.deadline());
        return new ResponseEntity<>(String.format("Blahopřeji, ToDo s názvem %s bylo uložené", toDoRecord.name()), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteToDo")
    public ResponseEntity<String> deleteTodo(@RequestParam Integer toDoId) {
        toDoService.deleteToDo(toDoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> allTodos() {
        return new ResponseEntity<>(toDoService.gettAllToDoes(), HttpStatus.OK);
    }


    @PatchMapping("/changeStatus")
    public ResponseEntity<String> changeStatus(@RequestParam Integer toDoId) {
        toDoService.changestatus(toDoId);
     //   log.info("status je změněn");
        return new ResponseEntity<>("Status je změněn", HttpStatus.OK);
    }
}
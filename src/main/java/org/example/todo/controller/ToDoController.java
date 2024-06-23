package org.example.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.todo.service.implementation.ToDoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.todo.service.ToDoService;

import java.time.LocalDate;

@Controller
@Slf4j
public class ToDoController {

    //indžektnem
    private final ToDoServiceImpl toDoService;

    public ToDoController(ToDoServiceImpl toDoService) {
        this.toDoService = toDoService;
    }

/*
    @PostMapping("/createToDo/{nameDescription}{deadLine}")
    public String createToDo(@PathVariable String nameDescription, @PathVariable LocalDate deadLine) {
        toDoService.createToDo(nameDescription,deadLine);
        return "redirect: /";
    }
*/

    @PostMapping("/createToDo")
    public String createToDoParam(@RequestParam String name,
                                  @RequestParam LocalDate deadLine) {

        toDoService.createToDo(name, deadLine);
        log.info(String.format("Uživatel vvtvořil todo s názvem '%s'", name));
        return "redirect:/";
    }

    @GetMapping
    public String allToDos(Model model) {
        model.addAttribute("todos", toDoService.gettAllToDoes());
        log.info(String.format("Uživatel právě vytvořil stránku"));
        return "index";
    }

    @PostMapping("/deleteToDo")
    public String deleteToDo(@RequestParam Integer toDoId) {
        toDoService.deleteToDo(toDoId);
        log.info(String.format("Uživatel vymazal todo s id '%s'", toDoId));
        return "redirect:/";
    }

    @PostMapping("/changeStatus")
    public String changeStatus(@RequestParam Integer toDoId) {
        toDoService.changestatus(toDoId);
        log.info(String.format("Uživatel změnil status todo s id '%s'", toDoId));
        return "redirect:/";
    }
}

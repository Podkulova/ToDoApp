package org.example.controller;

import org.example.service.implementation.ToDoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ToDoController {

    //indžektnem
    private final ToDoServiceImpl toDoService;

    public ToDoController(ToDoServiceImpl toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/createToDo")
    public String createToDoParam(@RequestParam String nameDescription,
                                  @RequestParam LocalDate deadLine) {

        toDoService.createToDo(nameDescription, deadLine);

        return "redirect:/";
    }

    @GetMapping
    public String allToDos(Model model) {
        model.addAttribute("todos", toDoService.gettAllToDoes());
        return "index";
    }

    @PostMapping("/deleteToDo")
    public String deleteToDo(@RequestParam Integer toDoId) {
        toDoService.deleteToDo(toDoId);
        return "redirect:/";
    }

    @PostMapping("/changeStatus")
    public String changeStatus(@RequestParam Integer toDoId) {
        toDoService.changestatus(toDoId);
        return "redirect:/";
    }
}

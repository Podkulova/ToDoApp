package org.example.todo.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.example.todo.exception.InvalidParamsExeption;
import org.example.todo.exception.InvalidStatusExeption;
import org.example.todo.exception.TodoNotFoundExeption;
import org.example.todo.model.ToDo;
import org.springframework.stereotype.Service;
import org.example.todo.repository.ToDoRepository;
import org.example.todo.service.ToDoService;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDorepository) {
        this.toDoRepository = toDorepository;
    }

    @Override
    public void createToDo(String name, LocalDate deadLine) {

        ToDo toDo = ToDo.builder()
                .name(name)
                .daadline(deadLine)
                .build();

        if (name == null || deadLine == null) {
            throw new InvalidParamsExeption("Jméno nebo deadline nemůže být null");
        }
        toDoRepository.save(toDo);
    }

    public List<ToDo> gettAllToDoes() {
        return toDoRepository.findAll();
    }


    public void deleteToDo(Integer toDoId) {
        ToDo todoName = toDoRepository.findById(toDoId)
                .orElseThrow(() -> new TodoNotFoundExeption(String.format("Todo with id: %d was not fount", toDoId)));
        if (todoName.isDone()) {
            toDoRepository.deleteById(toDoId);
            log.warn(String.format("Todo with id %d has been deleted", toDoId));
        } else {
            throw new InvalidStatusExeption(String.format("This todo with name '%s' has invalid state: '%s'", todoName.getName(), todoName.isDone()));
        }
    }

    public void changestatus(Integer todoId) {
        ToDo toDo = toDoRepository.findById(todoId).orElseThrow(() -> new TodoNotFoundExeption(String.format("Todo with id:%d was not found", todoId)));
        toDo.changeStatus();
        toDoRepository.save(toDo);
    }
}

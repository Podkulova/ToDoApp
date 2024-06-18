package org.example.service.implementation;

import org.example.model.ToDo;
import org.example.service.ToDoService;
import org.springframework.stereotype.Service;
import org.example.repository.ToDoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDorepository) {
        this.toDoRepository = toDorepository;
    }

    @Override
    public void createToDo(String nameDescription, LocalDate deadLine) {
        ToDo toDo = ToDo.builder()
                .nameDescription(nameDescription)
                .daadline(deadLine)
                .build();
        toDoRepository.save(toDo);
    }

    public List<ToDo> gettAllToDoes() {
        return toDoRepository.findAll();
    }


    public void deleteToDo(Integer toDoId) {
    //    log.warn(String.format("TOdo with id % ha been deleted"), toDoId);
            toDoRepository.deleteById(toDoId);
    }

    public void changestatus(Integer todoId) {
        ToDo toDo = toDoRepository.getReferenceById(todoId);
        toDo.changeStatus();
        toDoRepository.save(toDo);
    }
}

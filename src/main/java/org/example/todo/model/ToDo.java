package org.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate daadline;
    private boolean inProgress;
    private boolean isDone;
    private LocalDate finishDate;



    public boolean isDown() {
        return isDone;
    }

    public void setDown(boolean down) {
        isDone = down;
    }

    public void changeStatus() {
        isDone = !isDone;
    }

    public  boolean isNull() {
        return  (name == null || daadline == null || id == null);
    }
}

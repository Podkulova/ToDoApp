package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ToDoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ToDoApplication.class, args);
        log.info("Aplikace běží na adrese: http://localhost:8080/");
    }
}

package com.andressa.todolist.entities;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.andressa.todolist.enums.EnumPriority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@RestController
@Entity
@Table(name = "tarefas")
@Getter
@Setter

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column (unique = false, nullable = false, length = 50)
    private String tarefa;

    @NotEmpty
    private String description;

    @NotEmpty
    private EnumPriority priority;

    public Todo(){
        
    }

    public Todo(String tarefa, @NotEmpty String description, @NotEmpty EnumPriority priority) {
        this.tarefa = tarefa;
        this.description = description;
        this.priority = priority;
    }

}

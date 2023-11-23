package com.andressa.todolist.entities;

import java.util.UUID;
import com.andressa.todolist.enums.EnumPriority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = false, nullable = false, length = 50)
    private String task;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private EnumPriority priority;

    public Todo() {

    }

    public Todo(String task, String description, EnumPriority priority) {
        this.task = task;
        this.description = description;
        this.priority = priority;
    }
}

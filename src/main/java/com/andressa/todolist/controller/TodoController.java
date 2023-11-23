package com.andressa.todolist.controller;

import com.andressa.todolist.entities.Todo;
import com.andressa.todolist.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/tarefas")
    public ResponseEntity<List<Todo>> getAllTarefas() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }


    @PostMapping("/tarefa")
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody Todo todo) {
        Todo savedTodo = todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    @PutMapping("/tarefa/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable UUID id,
            @Valid @RequestBody Todo updatedTodo) {
        if (!todoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedTodo.setId(id);
        Todo savedTodo = todoRepository.save(updatedTodo);
        return ResponseEntity.ok(savedTodo);
    }

    @DeleteMapping("/tarefa/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable UUID id) {
        if (!todoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }

        todoRepository.deleteById(id);
        return ResponseEntity.ok("Tarefa apagada");
    }

}

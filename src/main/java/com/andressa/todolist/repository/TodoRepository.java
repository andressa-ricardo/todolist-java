package com.andressa.todolist.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.andressa.todolist.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, UUID>{
    
}

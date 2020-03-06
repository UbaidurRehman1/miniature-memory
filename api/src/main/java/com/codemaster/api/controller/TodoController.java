package com.codemaster.api.controller;

import java.net.URI;
import java.util.List;

import com.codemaster.api.entity.Todo;
import com.codemaster.api.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping("todos")
public class TodoController
{
    @Autowired
    TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getOne(@PathVariable Long id) {
        Todo todo = todoService.getOne(id);
        if (todo != null)
        {
            return ResponseEntity.ok(todo);
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("")
    public ResponseEntity<List<Todo>> getAll() {
        List<Todo> todos = todoService.getAll();
        if (todos.size() > 0)
        {
            return ResponseEntity.ok(todos);
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> delete(@PathVariable Long id)
    {
        Todo todo = todoService.delete(id);
        if (todo != null)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(todo);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Todo> add(@RequestBody Todo todo)
    {
        todo =  todoService.add(todo);
        if (todo != null)
        {
            final URI uri = MvcUriComponentsBuilder.fromController(getClass())
            .path("/{id}")
            .buildAndExpand(todo.getId())
            .toUri();
            return ResponseEntity.created(uri).body(todo);
        }

        return ResponseEntity.badRequest().build();
    }    
}
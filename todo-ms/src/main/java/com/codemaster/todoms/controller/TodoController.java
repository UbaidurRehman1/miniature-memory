package com.codemaster.todoms.controller;

import java.util.List;

import com.codemaster.todoms.entity.Todo;
import com.codemaster.todoms.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController
{
    @Autowired
    TodoService todoService;

    @GetMapping("/{id}")
    public Todo getOne(@PathVariable Long id) {
        return todoService.getOne(id);
    }

    @GetMapping("/")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @DeleteMapping("/{id}")
    public Todo delete(@PathVariable Long id) {
        return todoService.delete(id);
    }

    @PostMapping("/")
    public Todo add(@RequestBody Todo todo) {
        return todoService.add(todo);
    }    
}
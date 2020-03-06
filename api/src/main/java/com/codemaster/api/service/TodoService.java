package com.codemaster.api.service;

import java.util.List;

import com.codemaster.api.entity.Todo;


public interface TodoService
{
    public Todo getOne(Long id);
    public List<Todo> getAll();
    public Todo delete(Long id);
    public Todo add(Todo todo);
}
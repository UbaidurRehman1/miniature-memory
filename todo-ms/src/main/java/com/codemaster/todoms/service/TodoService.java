package com.codemaster.todoms.service;

import java.util.List;

import com.codemaster.todoms.entity.Todo;

public interface TodoService
{
    public Todo getOne(Long id);
    public List<Todo> getAll();
    public Todo delete(Long id);
    public Todo add(Todo todo);
}
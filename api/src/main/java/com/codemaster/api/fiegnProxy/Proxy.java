package com.codemaster.api.fiegnProxy;

import java.util.List;

import com.codemaster.api.entity.Todo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "gateway-server")
@RibbonClient(name = "todo-service")
public interface Proxy
{
    @GetMapping("todo-service/{id}")
    public Todo getOne(@PathVariable Long id);

    @GetMapping("todo-service/")
    public List<Todo> getAll();

    @DeleteMapping("todo-service/{id}")
    public Todo delete(@PathVariable Long id);

    @PostMapping("todo-service/")
    public Todo add(@RequestBody Todo entity);    
}
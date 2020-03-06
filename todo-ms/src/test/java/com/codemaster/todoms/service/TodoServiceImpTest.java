package com.codemaster.todoms.service;

import com.codemaster.todoms.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class TodoServiceImpTest {

    @Autowired
    TodoService todoService;

    @Test
    void getOne() {
        Todo todo = todoService.getOne(1L);
        assertThat(todo).isEqualTo(todo1());
    }

    @Test
    void getAll() {
        List<Todo> todos = todoService.getAll();
        assertThat(todos).contains(todo1(), todo2());
    }

    @Test
    void delete() {
        Todo todo = todoService.delete(1L);
        assertThat(todo).isNotIn(todoService.getAll());
    }

    @Test
    void add() {
        Todo todo = todoService.add(todo1());
        assertThat(todo).isNotNull();
        assertThat(todo1()).isEqualTo(todo);
    }

    private Todo todo1() {
        String string = "2020-03-04";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Todo(1L, "Task 1", "Do Home Assignment 1", date, false);
    }

    private Todo todo2() {
        String string = "2020-03-05";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Todo(2L, "Task 2", "Do Home Assignment 2", date, false);
    }
}
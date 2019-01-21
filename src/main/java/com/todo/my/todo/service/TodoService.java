package com.todo.my.todo.service;

import com.todo.my.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();

    Todo findById(int theId);

    void save(Todo theTodo);

    void deleteById(int theId);
}

package com.todo.my.todo.dao;

import com.todo.my.todo.entity.Todo;

import java.util.List;

public interface TodoDAO {
    List<Todo> findAll();

    Todo findById(int theId);

    void save(Todo theTodo);

    void deleteById(int theId);
}

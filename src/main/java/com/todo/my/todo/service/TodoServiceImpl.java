package com.todo.my.todo.service;

import com.todo.my.todo.dao.TodoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.todo.my.todo.entity.Todo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoDAO todoDAO;

    @Autowired
    public TodoServiceImpl(@Qualifier("todoDAOJpaImpl") TodoDAO theTodoDAO) {
        todoDAO = theTodoDAO;
    }

    @Override
    @Transactional
    public List<Todo> findAll() {
        return todoDAO.findAll();
    }

    @Override
    @Transactional
    public Todo findById(int theId) {
        return todoDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Todo theTodo) {
        todoDAO.save(theTodo);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        todoDAO.deleteById(theId);
    }
}

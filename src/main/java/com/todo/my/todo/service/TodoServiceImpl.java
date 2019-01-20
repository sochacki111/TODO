package com.todo.my.todo.service;

import com.todo.my.todo.dao.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.todo.my.todo.entity.Todo;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl( TodoRepository theTodoRepository) {
        todoRepository = theTodoRepository;
    }

    @Override
    @Transactional
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    @Transactional
    public Todo findById(int theId) {
        Optional<Todo> result = todoRepository.findById(theId);

        Todo theTodo = null;

        if(result.isPresent()) {
            theTodo = result.get();
        }
        else {
            throw new RuntimeException("Did not find todo with  id= " + theId);
        }

        return theTodo;
    }

    @Override
    @Transactional
    public void save(Todo theTodo) {
        todoRepository.save(theTodo);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        todoRepository.deleteById(theId);
    }
}

package com.todo.my.todo.rest;

import com.todo.my.todo.entity.Todo;
import com.todo.my.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoRestController {

    private TodoService todoService;

    @Autowired
    public TodoRestController(TodoService theTodoService) {
        todoService = theTodoService;
    }

    @GetMapping("/todos")
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/todos/{theId}")
    public Todo getTodo(@PathVariable int theId) {

        Todo todo = todoService.findById(theId);

        if (todo == null) {
            throw new RuntimeException("Todo id not found - " + theId);
        }

        return todo;
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo theTodo) {
        theTodo.setId(0);
        todoService.save(theTodo);

        return theTodo;
    }

    @PutMapping("/todos")
    public Todo updateTodo(@RequestBody Todo theTodo) {
        todoService.save(theTodo);
        return theTodo;
    }

    @DeleteMapping("/todos/{theId}")
    public String deleteTodo(@PathVariable int theId) {

        Todo todo = todoService.findById(theId);

        if(todo == null) {
            throw new RuntimeException("Todo id not found - " + theId);
        }

        todoService.deleteById(theId);

        return "Deleted todo with id = " + theId;
    }
}

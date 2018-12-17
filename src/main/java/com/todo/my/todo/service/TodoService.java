package com.todo.my.todo.service;

import org.springframework.stereotype.Service;
import com.todo.my.todo.model.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int idCount = 1;

//    static {todos.add(new Todo(40, "michas", "Learn Struts", new Date(), false));}

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();

        for(Todo todo : todos) {
            if(todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String user, String desc, Date targetDate, boolean isDone) {
        todos.add(new Todo(++idCount,user, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();

        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Todo retrieveTodo(int id) {
        for(Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
            return null;
    }

    public void updateTodo(Todo todo) {

        todos.remove(todo);
        todos.add(todo);


    }
}

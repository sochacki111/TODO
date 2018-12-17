package com.todo.my.todo.controller;

import com.todo.my.todo.model.Todo;
import com.todo.my.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap modelMap) {
        String name = (String) modelMap.get("name");
        modelMap.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap modelMap) {
        modelMap.addAttribute("todo", new Todo(0,(String) modelMap.get("name"), ""));
        return "todo";
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }
        service.addTodo((String) modelMap.get("name"),todo.getDescription());
        return "redirect:/list-todos";
}

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET )
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value= "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap) {
        Todo todo = service.retrieveTodo(id);
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value= "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        todo.setUser((String) modelMap.get("name"));
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }
}

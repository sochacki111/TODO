package com.todo.my.todo.controller;

import com.todo.my.todo.entity.Todo;
import com.todo.my.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService theTodoService) {
        this.todoService = theTodoService;
    }

/*
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("todo", new Todo());
        return "greeting";
    }
*/

/*    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String addPageTodo(@ModelAttribute Todo theTodo, Model model) {
        todoService.save(theTodo);
        model.addAttribute("todos", todoService.findAll());
        return "todo-list";
    }*/

}

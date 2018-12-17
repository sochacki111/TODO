package com.todo.my.todo.controller;


import com.todo.my.todo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap) {
        return "login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String showWelcomePage(ModelMap modelMap, @RequestParam String name, @RequestParam String password) {
        boolean isValidUser = service.validateUser(name,password);

        if(!isValidUser) {
            modelMap.put("message", "Invalid username or password. Please try again");
            return "login";
        }

        modelMap.put("name", name);
        return "list-todos";
    }
}

package com.todo.my.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

@Component
@SessionAttributes("name")
public class LoginService {

    @Autowired
    private LoginService service;

    public boolean validateUser(String userId, String password) {
        return userId.equalsIgnoreCase("root")
                && password.equalsIgnoreCase("toor");


    }


}

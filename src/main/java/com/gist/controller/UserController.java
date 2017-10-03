package com.gist.controller;

import com.gist.model.User;
import com.gist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List getUsers() {
        User user = new User(1L, "Vish", "de");
        return new ArrayList() {{
            add(user);
        }};
    }
}

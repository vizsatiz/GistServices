package com.gist.controller;

import com.gist.model.User;
import com.gist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List getUsers() {
        return userService.list();
    }

    @PostMapping(value = "/users")
    public ResponseEntity createCustomer(@Valid @RequestBody User user) {
        userService.save(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}

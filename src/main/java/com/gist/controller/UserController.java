package com.gist.controller;

import com.gist.constants.GistDefaultValueConstants;
import com.gist.model.User;
import com.gist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController extends GistBaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> get() {
        return userService.list();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getByPk(@PathVariable("id") Long id) {
        List<User> user = userService.get(id);
        if (0 == user.size()) {
            return handleEmptyObjects();
        }
        return new ResponseEntity<>(user.get(0), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        user.setLevel(GistDefaultValueConstants.USER_BEGINNER_LEVEL);
        User createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Long deletedId = userService.delete(id);
        if (deletedId == null) {
            return handleRecordNotFound();
        }
        return new ResponseEntity<>(deletedId, HttpStatus.OK);

    }

    @PutMapping("/users/{id}")
    public ResponseEntity put(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.update(id, user);
        if (updatedUser == null) {
            return handleRecordNotFound();
        }
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }
}

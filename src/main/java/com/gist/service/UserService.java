package com.gist.service;

import com.gist.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> list();
}

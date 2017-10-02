package com.gist.dao;

import com.gist.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    List<User> list();
}

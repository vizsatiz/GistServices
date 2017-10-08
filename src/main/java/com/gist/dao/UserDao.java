package com.gist.dao;

import com.gist.model.User;

import java.util.List;

public interface UserDao {

    User save(User user);

    List<User> list();

    List<User> get(Long id);

    Long delete(Long id);

    User update(Long id, User user);
}

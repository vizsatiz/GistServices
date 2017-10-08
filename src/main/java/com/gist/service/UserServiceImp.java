package com.gist.service;

import com.gist.dao.UserDao;
import com.gist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    public List<User> list() {
        return userDao.list();
    }

    @Override
    public List<User> get(Long id) {
        return userDao.get(id);
    }

    @Override
    public Long delete(Long id) {
        return userDao.delete(id);
    }

    @Override
    public User update(Long id, User user) {
        return userDao.update(id, user);
    }

}

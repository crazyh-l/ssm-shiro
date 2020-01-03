package com.haoling.test.service.Impl;

import com.haoling.test.dao.UserDao;
import com.haoling.test.pojo.T_user;
import com.haoling.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao ;

    public T_user findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}

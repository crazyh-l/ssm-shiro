package com.haoling.test.dao;

import com.haoling.test.pojo.T_user;

import java.util.Set;

public interface UserDao {

    T_user findUserByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}

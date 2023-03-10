package com.service;

import com.model.User;

import java.util.List;


public interface UserService {
    List<User> getusername();
    User create(User user);
//    void insert(User user);
//    User check(User exists)
    User getUserId(int systemid);
    User updateUser(User name);
    User deleteUser(int id);
}

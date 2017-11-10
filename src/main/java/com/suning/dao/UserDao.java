package com.suning.dao;

import java.util.List;

import com.suning.domain.User;

public interface UserDao {

    public int insert(User user);
    
    public User findUserById (int userId);
    
    public List<User> findAllUsers();
}

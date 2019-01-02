package com.ths.lxc.service.user;

import java.util.List;

import com.ths.lxc.model.user.User;

public interface IUserService {
    void insert(User user);
    
    List<User> getAll();
}

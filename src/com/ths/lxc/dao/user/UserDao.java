package com.ths.lxc.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ths.lxc.model.user.User;
@Repository
public interface UserDao {
   void insert(User user);
   List<User> getAll();
}

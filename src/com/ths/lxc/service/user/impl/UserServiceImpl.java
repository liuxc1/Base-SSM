package com.ths.lxc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ths.lxc.dao.user.UserDao;
import com.ths.lxc.model.user.User;
import com.ths.lxc.service.user.IUserService;
@Service
public class UserServiceImpl implements IUserService {
   @Autowired
    UserDao dao;
	
	@Override
	public void insert(User user) {
		dao.insert(user);

	}

	@Override
	public List<User> getAll() {
		
		return dao.getAll();
	}

}

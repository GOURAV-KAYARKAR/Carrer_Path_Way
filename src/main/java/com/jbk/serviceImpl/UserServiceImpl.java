package com.jbk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDao;
import com.jbk.daoImpl.UserDaoImpl;
import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;
import com.jbk.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public int createUser(User user) {
		int status = userDaoImpl.createUser(user);
		return status;
	}

	@Override
	public int deleteUser(String userName) {
		int status = userDaoImpl.deleteUser(userName);
		return status;
	}

	@Override
	public List<User> allUsers() {
		return userDaoImpl.allUsers();
	}

	@Override
	public User getUserByUsername(String userName) {
		return userDaoImpl.getUserByUsername(userName);
	}


	

}

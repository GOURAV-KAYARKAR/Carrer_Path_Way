package com.jbk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.UserLoginDao;
import com.jbk.dto.LoginRequest;
import com.jbk.service.LoginService;
@Repository
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserLoginDao userLoginDao;
	
	public Object userLogin(LoginRequest loginRequest) {
		
		return userLoginDao.userlogin(loginRequest);
	}

}

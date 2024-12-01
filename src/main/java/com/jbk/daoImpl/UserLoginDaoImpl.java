package com.jbk.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.UserLoginDao;
import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Object userlogin(LoginRequest loginRequest) {
		try {
			Session session = sessionFactory.openSession();
			User dbuser = session.get(User.class, loginRequest.getUsername());

			if (dbuser != null) {
				if (dbuser.getPassword().equals(loginRequest.getPassword())) {
					return dbuser;
				}

			} else {
				return "Invalid username and password";

			}

		} catch (Exception e) {
			e.printStackTrace();
			return " Some wents Wrong";
		}
		return null;

	}
}
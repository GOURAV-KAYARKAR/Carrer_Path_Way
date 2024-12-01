package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.User;
import com.jbk.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/create-user")
	public String createUser(@RequestBody  @Valid User user) {
		int status = userServiceImpl.createUser(user);
		switch (status) {
		case 1:
			return "User added sussfully";
		case 2:
			return "User already exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@DeleteMapping("/deleteUser/{username}")
	public String deleteUser(@PathVariable(name = "username") String userName) {
		int status = userServiceImpl.deleteUser(userName);
		switch (status) {
		case 1:
			return "User delete sussfully";
		case 2:
			return "User not exist";
		case 3:
			return "Something went wrong";
		default:
			return "";
		}
	}

	@GetMapping("/allUsers")
	public List<User> allUsers() {
		return userServiceImpl.allUsers();
	}

	@GetMapping("/getUser/{username}")
	public String getUserByUsername(@PathVariable(name = "username") String userName) {
		User user = userServiceImpl.getUserByUsername(userName);
		if (user != null) {
			return user.toString();
		} else {
			return "User not found";
		}
	}

}

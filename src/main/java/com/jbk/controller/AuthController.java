package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.dto.LoginRequest;
import com.jbk.service.LoginService;

@RestController
@RequestMapping("/auth")

public class AuthController {
	@Autowired
	public LoginService loginService;

	@PostMapping("login-user")
	public Object userLogin(@RequestBody LoginRequest loginRequest) {
		Object obj = loginService.userLogin(loginRequest);

		if (obj != null) {
			return obj;
		}
		return "User not found";

	}

}

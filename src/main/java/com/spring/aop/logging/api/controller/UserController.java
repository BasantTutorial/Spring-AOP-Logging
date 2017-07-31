package com.spring.aop.logging.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.aop.logging.api.dto.User;
import com.spring.aop.logging.api.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "/getUsers")
	public List<User> getUsers() {
		return service.getUsers();

	}

	@RequestMapping(value = "/getUser/{userId}")
	public User getUser(@PathVariable("userId") String userId) {
		return service.getUser(userId);
	}
}

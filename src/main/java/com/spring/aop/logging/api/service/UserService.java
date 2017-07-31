package com.spring.aop.logging.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.aop.logging.api.dao.UserDAO;
import com.spring.aop.logging.api.dto.User;

@Service
public class UserService {
	@Autowired
	private UserDAO dao;

	public List<User> getUsers() {
		return dao.getUsers();
	}

	public User getUser(String id) {
		return dao.getUserByID(id);
	}
}

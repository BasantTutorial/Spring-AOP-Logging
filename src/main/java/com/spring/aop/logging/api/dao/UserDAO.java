package com.spring.aop.logging.api.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.spring.aop.logging.api.dto.User;

@Repository
public class UserDAO {

	public static List<User> users = null;

	static {
		users = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			users.add(new User("userID" + i, "user" + i, new Random()
					.nextInt(98), "profession" + i));
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public User getUserByID(String userID) {
		return users.stream().filter(user -> user.getUserId().equals(userID))
				.findAny().get();
	}
}

package com.spring.aop.logging.api.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = { "userId", "name", "age", "profession" })
public class User {

	private String userId;
	private String name;
	private int age;
	private String profession;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public User(String userId, String name, int age, String profession) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.profession = profession;
	}

	public User() {
	}

}

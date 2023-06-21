package com.naveen.service;

import com.naveen.entity.User;

public interface UserServiceInterface {

	public User createUser(User user);

	public User getUser(Integer id);
}

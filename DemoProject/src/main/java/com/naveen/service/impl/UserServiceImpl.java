package com.naveen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.entity.User;
import com.naveen.repository.UserRepository;
import com.naveen.service.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		System.out.println("UserServiceImpl.createUser()");
		return userRepository.save(user);
	}

	@Override
	public User getUser(Integer id) {
		return userRepository.findById(id).orElse(null);
	}
}

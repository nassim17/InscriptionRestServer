package com.bnguimgo.springbootrestserver.service;

import java.util.Collection;

import com.bnguimgo.springbootrestserver.model.User;

public interface UserService {

	Collection<User> getAllUsers();
	
	User getUserById(Long id);
	
	User findByLogin(String login);
	
	User saveOrUpdateUser(User user);
	
	void deleteUser(Long id);
	
}

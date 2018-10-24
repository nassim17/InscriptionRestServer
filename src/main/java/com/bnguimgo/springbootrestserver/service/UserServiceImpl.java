package com.bnguimgo.springbootrestserver.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnguimgo.springbootrestserver.dao.UserRepository;
import com.bnguimgo.springbootrestserver.model.User;

@Service(value = "userService")//l'annotation @Service est optionnelle ici, car il n'existe qu'une seule implementation de l'interface UserService
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Collection<User> getAllUsers() {
		return IteratorUtils.toList(userRepository.findAll().iterator());
	}

	 @Override
	 public User getUserById(Long id) {
		 return userRepository.findById(id).get(); //https://stackoverflow.com/questions/49561425/cant-use-findone-in-my-code-with-jparepository
	 }

	@Override
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	@Transactional(readOnly=false)
	public User saveOrUpdateUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteUser(Long id) {
		userRepository.deleteById(id);	
	}

}

package com.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	// create object of logger
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	// inject repository here
	@Autowired
	private UserRepository repository;

	@Override
	public User insertUserDeatils(User user) {
		log.info("Inside UserServiceImpl-> in inserUserDeatils() Method");
		return repository.save(user);
	}

	@Override
	public User getUserDeatils(int id) {
		log.info("Inside UserServiceImpl-> in getUserDeatils() Method");
		return repository.findUserById(id);
	}

	@Override
	public List<User> getAllUserDeatils(User user) {
		log.info("Inside UserServiceImpl-> in getAllUserDeatils() Method");
		List<User> list = (List<User>) repository.findAll();
		return list;
	}

	@Override
	public void deleteUserById(int id) {
		log.info("Inside UserServiceImpl-> in deleteUserById() Method");
		repository.deleteById(id);
	}

	@Override
	public User updateUserDeatils(User user) {
		log.info("Inside UserServiceImpl-> in updateUserDeatils() Method");
		User user2 = repository.findById(user.getId()).orElse(null);
		if (user2 != null) {
			// give the values which you wanted to update
			user2.setFirstName(user.getFirstName());
			user2.setLastName(user.getLastName());
			user2.setEmail(user.getEmail());
			user2.setAddress(user.getAddress());
			repository.save(user2);
			return user2;
		}
		return null;
	}

}

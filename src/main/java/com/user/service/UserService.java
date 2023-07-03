package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {

	// this will used to insert user details
	public User insertUserDeatils(User user);

	// this will used to get user details by id
	public User getUserDeatils(int id);

	// this will used to get all user details
	public List<User> getAllUserDeatils(User user);

	// this will used to delete the user details
	public void deleteUserById(int id);

	// this is used to update user details
	public User updateUserDeatils(User user);

}

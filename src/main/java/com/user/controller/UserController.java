package com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

/*
 * @author Yash Mate
 */
@RestController
public class UserController {
	// create object of logger to use
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	// inject service here
	@Autowired
	private UserService service;

	/*
	 * design a restful web service to add user details
	 */
	@PostMapping("/addUserDeatils")
	public ResponseEntity<User> insertUserDeatils(@RequestBody User user) {
		log.info("Inside UserController-> insertUserDeatils Method");
		User user2 = service.insertUserDeatils(user);
		return ResponseEntity.ok().body(user2);
	}

	/*
	 * design a restful web services to get user details
	 */
	@GetMapping("/GetUser/{id}")
	public ResponseEntity<User> getUserDeatils(@PathVariable("id") int id) {
		log.info("Inside UserController-> in getUserDeatils() method");
		User user = service.getUserDeatils(id);
		return ResponseEntity.ok().body(user);
	}

	/*
	 * design a restful web services to get all users details
	 */
	@GetMapping("/getallUsersList")
	public List<User> getAllUserDeatils(User user) {
		log.info("Inside UserController-> in getAllUserDeatils() method");
		return service.getAllUserDeatils(user);
	}

	/*
	 * design restful web services to delete user by id
	 */
	@DeleteMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable("id") int id) {
		log.info("Inside UserController-> in deleteUserById() method");
		service.deleteUserById(id);
		return "Data For ID " + id + " Deleted Succesfully";
	}

	/*
	 * design a restful web services to update the details of user
	 */
	@PutMapping("/updateUserDetails")
	public User updateUserDeatils(@RequestBody User user) {
		log.info("Inside UserController-> in updateUserDeatils() method");
		return service.updateUserDeatils(user);
	}

}

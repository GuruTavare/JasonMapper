package com.jsaon.jsonmapper.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsaon.jsonmapper.entity.Geo;
import com.jsaon.jsonmapper.entity.User;
import com.jsaon.jsonmapper.service.IUserService;

@RestController
@RequestMapping("/api/users")
//@Slf4j
public class UserController {
	private final IUserService iUserService;
	
	private static final Logger logger=LoggerFactory.getLogger(UserController.class); 

	public UserController(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	@PostMapping("/create")
	public ResponseEntity<List<User>> createUser(@RequestBody List<User> users) {
		 logger.info("Received request to create users: {}", users);
		List<User> all = iUserService.addAll(users);
		logger.info("Successfully created users: {}", all);
		return new ResponseEntity<List<User>>(all, HttpStatus.CREATED);

	}
	@GetMapping("/get")
	public ResponseEntity<List<User>> fetchAllUsers(){
		logger.info("Received request to fetch all users");

		List<User> allUsers = iUserService.getAllUsers();
		logger.info("Returning all users: {}", allUsers);
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		
		logger.info("Received request to get user by ID: {}", id);

        ResponseEntity<User> response = iUserService.getById(id);

        logger.info("Returning response for ID {}: {}", id, response);
        return response;
	}	
	@GetMapping("/getCoordinates/{id}")
	public ResponseEntity<Geo> getUserCoordinatesById(@PathVariable int id){
		
		logger.info("Received request to get user coordinates by ID: {}", id);
		
		ResponseEntity<Geo> response = iUserService.getByCoordinatesById(id);
		
		logger.info("Returning response for ID {}: {}", id, response);
		return response;
	}	

}

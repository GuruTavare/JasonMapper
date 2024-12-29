package com.jsaon.jsonmapper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsaon.jsonmapper.entity.Geo;
import com.jsaon.jsonmapper.entity.User;

@Service
//@Slf4j
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	List<User> usersList = new ArrayList<User>();

	@Override
	public List<User> getAllUsers() {

		logger.info("Fetching all users");
		return usersList;
	}

	@Override
	public List<User> addAll(List<User> users) {
		logger.info("Adding users: {}", users);
		usersList.addAll(users);
		logger.info("Current users list: {}", usersList);
		return usersList;
	}

	@Override
	//@Cacheable(value = "users", key = "#id")
	public ResponseEntity<User> getById(int id) {
		logger.info("Searching for user with ID: {}", id);

		Optional<User> first = usersList.stream().filter(u -> u.getId() == id).findFirst();

		if (first.isPresent()) {
			logger.info("User found: {}", first.get());
			return ResponseEntity.ok(first.get());
		} else {
			logger.warn("User not found with ID: {}", id);
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<Geo> getByCoordinatesById(int id) {
		logger.info("Searching for userGeo with ID: {}", id);
		Optional<User> user = usersList.stream().filter(u -> u.getId() == id).findFirst();
		if (user.isPresent()) {
			logger.info("User found: {}", user.get());
			Geo geo = user.get().getAddress().getGeo();
			logger.info("UserGeo found: {}", geo);
			return ResponseEntity.ok(geo);
		} else {
			logger.warn("User Geo not found with ID: {}", id);
			return ResponseEntity.notFound().build();
		}

	}

}

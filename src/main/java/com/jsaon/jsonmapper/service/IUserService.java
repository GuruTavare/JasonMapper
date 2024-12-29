package com.jsaon.jsonmapper.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsaon.jsonmapper.entity.Geo;
import com.jsaon.jsonmapper.entity.User;

public interface IUserService {
	List<User> getAllUsers();
	List<User> addAll(List<User> users);
	ResponseEntity<User> getById(int id);
	ResponseEntity<Geo> getByCoordinatesById(int id);

}

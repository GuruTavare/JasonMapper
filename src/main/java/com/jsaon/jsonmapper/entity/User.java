package com.jsaon.jsonmapper.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
	
	private Long id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	private Company company;
	private Address address;
	

}

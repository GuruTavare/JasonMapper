package com.jsaon.jsonmapper.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Address {
	private String  street;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;
      

}

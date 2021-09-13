package com.everis.d4i.tutorial.json;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorDataRest {
	
	private Long id;
	private String name;
	private String lastName;
	private Short age;
	private String nationality;
	
	
	public ActorDataRest(long id, String name, String lastName) {
		
		this.id=id;
		this.name=name;
		this.lastName=lastName;
	}
	public ActorDataRest() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}

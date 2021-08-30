package com.everis.d4i.tutorial.json;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable {

	private static final long serialVersionUID = 1482282774256673014L;

	private Long id;
	private String name;
	private String lastName;
	private Short age;
	private String nationality;
	private List <ChapterRest> chapters;
	
	
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
	public List<ChapterRest> getChapters() {
		return chapters;
	}
	public void setChapters(List<ChapterRest> chapters) {
		this.chapters = chapters;
	}
	

	
}

package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "ACTORS")
public class Actor implements Serializable {

	
	private static final long serialVersionUID = 1482282774256673014L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "AGE")
	private Short age;
	
	@Column(name = "NATIONALITY")
	private String nationality;
	
	@JoinTable(
			name = "actors_chapters",
			joinColumns= @JoinColumn(name= "ID_ACTOR", nullable = false),
			inverseJoinColumns = @JoinColumn(name= "ID_CHAPTER", nullable = false)
		)
	@ManyToMany
	private List<Chapter> chapters;

	public Actor(long id, String name, String lastName, short age, String nationality) {
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.age=age;
		this.nationality=nationality;
	}

	public Actor() {
		
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

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	
	
	
	
}

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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

	
	
	
	
	
	
}

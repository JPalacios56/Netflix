package com.everis.d4i.tutorial.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Category implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", unique = true)
	private String name;

	@JoinTable(
		name = "tvshows_categories",
		joinColumns= @JoinColumn(name= "CATEGORY_ID", nullable = false),
		inverseJoinColumns = @JoinColumn(name= "TV_SHOW_ID", nullable = false)
	)
	@ManyToMany
	private List<TvShow> tvShows;
	
	public Category() {
		
	}

	public Category(long id, String name) {

		this.id=id;
		this.name=name;
	}

	public Category(long id, String name, List<TvShow> list) {
		this.id= id;
		this.name= name;
		this.tvShows=list;
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

	public List<TvShow> getTvShows() {
		return tvShows;
	}

	public void setTvShows(List<TvShow> tvShows) {
		this.tvShows = tvShows;
	}

}

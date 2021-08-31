package com.everis.d4i.tutorial.json;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AwardTvShowRest {

	private Long id;
	private String name;
	
	public AwardTvShowRest(Long id, String name) {
		this.id=id;
		this.name=name;
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
	
	
	
}

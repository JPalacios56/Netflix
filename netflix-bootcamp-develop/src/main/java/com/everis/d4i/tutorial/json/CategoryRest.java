package com.everis.d4i.tutorial.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryRest implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	private Long id;
	private String name;

	public CategoryRest(long id, String name) {
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

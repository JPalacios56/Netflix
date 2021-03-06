package com.everis.d4i.tutorial.json;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorDataRest {
	
	private Long id;
	private String name;
	private String lastName;
	private Short age;
	private String nationality;
	
	
}

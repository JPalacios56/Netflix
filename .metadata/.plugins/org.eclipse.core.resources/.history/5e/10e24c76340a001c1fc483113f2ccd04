package com.everis.d4i.tutorial.json;

import java.io.Serializable;

import com.everis.d4i.tutorial.entities.Season;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChapterRest implements Serializable {

	private static final long serialVersionUID = 8725949484031409482L;

	private Long id;
	private short number;
	private String name;
	private short duration;
	private SeasonRest season;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public short getNumber() {
		return number;
	}

	public void setNumber(short number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public String getSeasonName() {
		return season.getName();
	}
	public String getTvShow() {
		return season.getTvShow();
	}

	public void setSeason(SeasonRest season) {
		this.season = season;
	}



	
	

}

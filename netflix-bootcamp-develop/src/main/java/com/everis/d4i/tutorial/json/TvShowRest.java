package com.everis.d4i.tutorial.json;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvShowRest implements Serializable {

	private static final long serialVersionUID = 4916713904971425156L;

	private Long id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private Year year;
	private byte recommendedAge;
	private String advertising;
	private List<CategoryRest> categories;


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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public byte getRecommendedAge() {
		return recommendedAge;
	}

	public void setRecommendedAge(byte recommendedAge) {
		this.recommendedAge = recommendedAge;
	}

	public String getAdvertising() {
		return advertising;
	}

	public void setAdvertising(String advertising) {
		this.advertising = advertising;
	}

	public List<CategoryRest> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryRest> categories) {
		this.categories = categories;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(advertising, categories, id, longDescription, name, recommendedAge, shortDescription, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TvShowRest other = (TvShowRest) obj;
		return Objects.equals(advertising, other.advertising) && Objects.equals(categories, other.categories)
				&& Objects.equals(id, other.id) && Objects.equals(longDescription, other.longDescription)
				&& Objects.equals(name, other.name) && recommendedAge == other.recommendedAge
				&& Objects.equals(shortDescription, other.shortDescription) && Objects.equals(year, other.year);
	}
	

}

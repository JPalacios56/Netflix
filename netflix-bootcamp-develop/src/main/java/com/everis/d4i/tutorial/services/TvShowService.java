package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.AwardTvShowRest;
import com.everis.d4i.tutorial.json.TvShowRest;

public interface TvShowService {

	//List<TvShowRest> getTvShowsByCategory(Long categoryId) throws NetflixException;

	TvShowRest getTvShowById(Long id) throws NetflixException;	

	TvShowRest updateTvShow(Long id, String name)throws NetflixException;
	
	TvShowRest addCategoryToTvShow(Long idTvShow, Long idCategory) throws NetflixException;
	
	TvShowRest deleteTvShow(Long idTvShow) throws NetflixException;
	
	List<AwardTvShowRest> getAwards(Long idTvshow) throws NetflixException; 
	
	
}

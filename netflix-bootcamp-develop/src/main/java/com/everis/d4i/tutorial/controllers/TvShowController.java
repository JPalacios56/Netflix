package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.AwardTvShowRest;
import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface TvShowController {

	//NetflixResponse<List<TvShowRest>> getTvShowsByCategory(Long categoryId) throws NetflixException;

	NetflixResponse<TvShowRest> getTvShowById(Long id) throws NetflixException;

	NetflixResponse<TvShowRest> updateTvShow(Long id, String name) throws NetflixException;
	
	NetflixResponse<TvShowRest> addCategoryToTvShowRest(Long id_TvShow, Long id_Category) throws NetflixException;

	NetflixResponse<TvShowRest> deleteTvShow(Long id_TvShow) throws NetflixException;
	
	NetflixResponse<List<AwardTvShowRest>> getAwards(Long id_tvShow) throws NetflixException;
	
}

package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorDataRest;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface ActorController {

	
	NetflixResponse<List<ActorDataRest>> getActors() throws NetflixException;
	
	NetflixResponse<ActorRest> getActorById(Long id) throws NetflixException;
	
	NetflixResponse<ActorDataRest> addActor(ActorDataRest actorDataRest) throws NetflixException;
	
	NetflixResponse<ActorDataRest> updateActor(Long id,ActorDataRest actorDataRest)throws NetflixException;

	NetflixResponse<String> deleteActor(Long id) throws NetflixException;

	NetflixResponse<ActorRest> getChapters(Long id) throws NetflixException;
	

}

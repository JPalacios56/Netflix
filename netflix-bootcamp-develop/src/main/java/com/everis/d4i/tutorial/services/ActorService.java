package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorDataRest;
import com.everis.d4i.tutorial.json.ActorRest;

public interface ActorService {
	
	List<ActorDataRest> getAllActorsData() throws NetflixException;
	
	ActorRest getActor(Long id) throws NetflixException;

	ActorRest addActor(ActorRest actorRest)throws NetflixException;
	
	ActorDataRest updateActor(Long id, ActorDataRest actorDataRest)throws NetflixException;
	
	ActorRest deleteActor(Long id) throws NetflixException;
	
	ActorRest getChapters(Long id) throws NetflixException;
}

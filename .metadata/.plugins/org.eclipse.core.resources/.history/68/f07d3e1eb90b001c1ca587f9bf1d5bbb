package com.everis.d4i.tutorial.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.InternalServerErrorException;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ActorDataRest;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class ActorServicesImpl implements ActorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	
	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ChapterRepository chapterRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ActorDataRest> getAllActorsData() throws NetflixException {
		
		List<ActorDataRest>actorDataRests= new ArrayList();
		List<Actor> actors=actorRepository.findAll();
		
		for(int i=0; i<actors.size();i++) {
			ActorDataRest aux= new ActorDataRest();
			aux.setId(actors.get(i).getId());
			aux.setName(actors.get(i).getName());
			aux.setLastName(actors.get(i).getLastName());
			aux.setAge(actors.get(i).getAge());
			aux.setNationality(actors.get(i).getNationality());
		
			actorDataRests.add(aux);
		}

		
		return actorDataRests;
	}
	
	@Override
	public ActorRest getActor(Long id) throws NetflixException {

		try {
			return modelMapper.map(actorRepository.getById(id), ActorRest.class);
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}
	}

	@Override
	public ActorRest addActor(final ActorRest actorRest) throws NetflixException {
			
			Actor actor= new Actor();
			actor.setName(actorRest.getName());
			actor.setLastName(actorRest.getLastName());
			actor.setAge(actorRest.getAge());
			actor.setNationality(actorRest.getNationality());
			
			try {
				actorRepository.save(actor);
			} catch (final Exception e) {
				LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
				throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
			}
			
			
		return modelMapper.map(actor, ActorRest.class);

	}

	@Override
	public ActorDataRest updateActor(Long id, final ActorDataRest actorDataRest) throws NetflixException {
		
		
				
			Actor actor= actorRepository.getById(id);
			actor.setName(actorDataRest.getName());
			actor.setLastName(actorDataRest.getLastName());
			actor.setAge(actorDataRest.getAge());
			actor.setNationality(actorDataRest.getNationality());
			
			try {
				actorRepository.save(actor);
			} catch (final Exception e) {
				LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
				throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
			}
			
			
		return modelMapper.map(actor, ActorDataRest.class);
	}

	@Override
	public ActorRest deleteActor(Long id) throws NetflixException {
			
		try {
			actorRepository.deleteById(id);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
		
		return null;
	}

	@Override
	public ActorRest getChapters(Long id) throws NetflixException {
	
		try {		
			List <ChapterRest> chapterRests = new ArrayList<>(); 
			ActorRest actorRest= new ActorRest();
			
			Actor actor = actorRepository.getById(id);
			List<Chapter> chapters = actor.getChapters();
			
			for(int i = 0; i<chapters.size(); i++) {
			
			ChapterRest chapterRest = modelMapper.map(chapters.get(i), ChapterRest.class);
			chapterRests.add(chapterRest);
				
			}	
			actorRest.setChapters(chapterRests);
			return actorRest;
			
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	

	
}

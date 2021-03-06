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

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ActorDataRest> getAllActorsData() throws NetflixException {

		List<ActorDataRest> actorDataRest = new ArrayList<ActorDataRest>();
		List<Actor> actors = actorRepository.findAll();

		for (Actor actor : actors) {
			ActorDataRest aux = new ActorDataRest();
			aux.setId(actor.getId());
			aux.setName(actor.getName());
			aux.setLastName(actor.getLastName());
			aux.setAge(actor.getAge());
			aux.setNationality(actor.getNationality());
			actorDataRest.add(aux);
		}
//		actors.stream().map(actor-> {ActorDataRest aux = new ActorDataRest();
//			aux.setId(actor.getId());
//			aux.setName(actor.getName());
//			aux.setLastName(actor.getLastName());
//			aux.setAge(actor.getAge());
//			aux.setNationality(actor.getNationality());
//			return aux;}).toList();

		return actorDataRest;
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
	public ActorDataRest addActor(final ActorDataRest actorDataRest) throws NetflixException {

		Actor actor = new Actor();
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
	public ActorDataRest updateActor(Long id, final ActorDataRest actorDataRest) throws NetflixException {

		Actor actor = actorRepository.getById(id);
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
	public String deleteActor(Long id) throws NetflixException {

		try {
			actorRepository.deleteById(id);
		} catch (final Exception e) {
			LOGGER.error(ExceptionConstants.INTERNAL_SERVER_ERROR, e);
			throw new InternalServerErrorException(ExceptionConstants.INTERNAL_SERVER_ERROR);
		}

		return "Actor eliminado";
	}

	@Override
	public ActorRest getChapters(Long id) throws NetflixException {

		try {
			List<ChapterRest> chapterRests = new ArrayList<>();
			ActorRest actorRest = new ActorRest();

			Actor actor = actorRepository.getById(id);
			List<Chapter> chapters = actor.getChapters();

			for (int i = 0; i < chapters.size(); i++) {

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

package com.everis.d4i.tutorial.controllers.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.everis.d4i.tutorial.controllers.ActorController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorDataRest;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;
import com.everis.d4i.tutorial.utils.constants.RestConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "ActorController", description = "REST API de la entidad Actor")
@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTOR)
public class ActorControllerImpl implements ActorController {
	
	
	@Autowired
	private ActorService actorService;

	
	@Override
	@ApiOperation(value = "Devuelve una lista de con todos los actores", response = Iterable.class)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<List<ActorDataRest>> getActors() throws NetflixException {

		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getAllActorsData());
	}


	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.RESOURCE_ID ,produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorRest> getActorById(@PathVariable Long id) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getActor(id));
	}


	@Override
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorDataRest> addActor(@ApiParam(value = RestConstants.PARAMETER_ACTOR, required = true) @RequestBody @Valid final ActorDataRest actorDataRest)
			throws NetflixException {
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.addActor(actorDataRest));
	}


	@Override
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = RestConstants.RESOURCE_ID,produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorDataRest> updateActor(@PathVariable Long id,@ApiParam(value = RestConstants.PARAMETER_ACTOR, required = true) @RequestBody @Valid final ActorDataRest actorDataRest) 
			throws NetflixException {
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.updateActor(id,actorDataRest));
	}


	@Override
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = RestConstants.RESOURCE_ID,produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<String> deleteActor(@PathVariable Long id) throws NetflixException {
		actorService.deleteActor(id);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK
				);
	}


	@Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/chapters/{id_actor}",produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<ActorRest> getChapters(@PathVariable Long id_actor) throws NetflixException {
	
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getChapters(id_actor));
	}


}

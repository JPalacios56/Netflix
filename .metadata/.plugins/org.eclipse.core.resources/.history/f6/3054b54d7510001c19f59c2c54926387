package com.everis.d4i.tutorial.services.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorDataRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ActorServicesImplTest {

	@Mock
	private ActorRepository actorRepository;
	
	@InjectMocks
	private ActorServicesImpl actorService;
	
	@Test
	void testGetActors() throws NetflixException {

		Mockito.when(actorRepository.findAll())
		.thenReturn(Lists.list(new Actor(1L,"Jose","Palacios",(short)25,"España")
				,new Actor(2L,"Manuel","Palacios",(short)24,"Francia")));
		
		List <ActorDataRest> actors= actorService.getAllActorsData();
		
		assertEquals((long) 1L,actors.get(0).getId());
		assertEquals("Manuel",actors.get(1).getName());
	}
	
	
}

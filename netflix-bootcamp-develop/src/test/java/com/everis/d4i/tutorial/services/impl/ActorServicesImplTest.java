//package com.everis.d4i.tutorial.services.impl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//import org.assertj.core.util.Lists;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.everis.d4i.tutorial.entities.Actor;
//import com.everis.d4i.tutorial.entities.Category;
//import com.everis.d4i.tutorial.exceptions.NetflixException;
//import com.everis.d4i.tutorial.json.ActorDataRest;
//import com.everis.d4i.tutorial.repositories.ActorRepository;
//import com.everis.d4i.tutorial.services.ActorService;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class ActorServicesImplTest {
//
//	@Mock
//	private ActorRepository actorRepository;
//
//	@InjectMocks
//	private ActorServicesImpl actorService;
//
//	@Test
//	void testGetActors() throws NetflixException {
//
//		// given(inicializar objetos + mokito when)
//		Mockito.when(actorRepository.findAll())
//				.thenReturn(Lists.list(new Actor(1L, "Jose", "Palacios", (short) 25, "España"),
//						new Actor(2L, "Manuel", "Palacios", (short) 24, "Francia")));
//
//		// when(llamar al metodo real)
//		List<ActorDataRest> actors = actorService.getAllActorsData();
//
//		// then(comprobaciones)
//		assertThat(actors.get(0).getId()).isEqualTo(1);	
//	}
//
//	@Test
//	public void updateActor() throws Exception {
//
//		// given(inicializar objetos + mokito when)
//
//		Actor actor = new Actor();
//		actor.setId(1L);
//		actor.setName("Jose");
//		actor.setLastName("Palacios");
//		actor.setAge((short) 24);
//		actor.setNationality("España");
//
//		ActorDataRest actorUpdate = new ActorDataRest();
//		actorUpdate.setId(1L);
//		actorUpdate.setName("Manuel");
//		actorUpdate.setLastName("Palacios");
//		actorUpdate.setAge((short) 27);
//		actorUpdate.setNationality("España");
//
//		Mockito.when(actorRepository.getById(1L)).thenReturn(actor);
//		Mockito.when(actorRepository.save(Mockito.any(Actor.class))).thenReturn(actor);
//		
//		// when(llamar al metodo real)
//
//		ActorDataRest actorFinal = actorService.updateActor(1L, actorUpdate);
//
//		// then(comprobaciones)
//
//		assertThat(actorFinal)
//		.isEqualTo(actorUpdate)
//		.isNotNull();
//	}
//
//	@Test
//	public void addActor() throws Exception {
//
//		// given(inicializar objetos + mokito when)
//
//		Actor actorSave = new Actor();
//		actorSave.setId(1L);
//		actorSave.setName("Jose");
//		actorSave.setLastName("Palacios");
//		actorSave.setAge((short) 24);
//		actorSave.setNationality("España");
//
//		ActorDataRest actorAddRest = new ActorDataRest();
//		actorAddRest.setId(1L);
//		actorAddRest.setName("Jose");
//		actorAddRest.setLastName("Palacios");
//		actorAddRest.setAge((short) 24);
//		actorAddRest.setNationality("España");
//
//		Mockito.when(actorRepository.save(Mockito.any(Actor.class))).thenReturn(actorSave);
//		
//		// when(llamar al metodo real)
//		
//		ActorDataRest actorFinal = actorService.addActor(actorAddRest);
//		
//		// THEN (Comprobaciones)
//		
//		assertThat(actorFinal.getName()).isEqualTo(actorAddRest.getName());
//		
//
//	}
//
//
//}

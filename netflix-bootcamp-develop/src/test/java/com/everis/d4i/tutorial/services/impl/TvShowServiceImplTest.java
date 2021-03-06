//package com.everis.d4i.tutorial.services.impl;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.everis.d4i.tutorial.entities.TvShow;
//import com.everis.d4i.tutorial.exceptions.NetflixException;
//import com.everis.d4i.tutorial.json.TvShowRest;
//import com.everis.d4i.tutorial.repositories.TvShowRepository;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class TvShowServiceImplTest {
//
//
//	@Mock
//	TvShowRepository tvShowRepository;
//	
//	@InjectMocks
//	TvShowServiceImpl tvShowService;
//		
//
//	@Test
//	void getTvShowById() throws NetflixException {
//		
//		TvShow tvShow = new TvShow();
//		tvShow.setName("Serie1");
//		tvShow.setLongDescription("Descripcion2");
//		tvShow.setShortDescription("Descripcion1");
//	
//		Mockito.when(tvShowRepository.getById(1L)).thenReturn(tvShow);	
//		TvShowRest tvShowExpect = tvShowService.getTvShowById(1L);
//		assertThat(tvShowExpect.getName()).isEqualTo(tvShow.getName());
//		
//	}
//	
//}

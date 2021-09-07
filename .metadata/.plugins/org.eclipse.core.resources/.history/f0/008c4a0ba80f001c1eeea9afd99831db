package com.everis.d4i.tutorial.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.TvShowService;

class TvShowServiceImplTest {

	@Autowired
	TvShowService tvShowService;
	
	TvShowRepository tvShowRepository;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() throws NetflixException {
		
		long id= 1;
		String name = "Juego de tronos";
		String nameTv=tvShowService.getTvShowById(id).getName();
		assertEquals(name, nameTv);
	}
}

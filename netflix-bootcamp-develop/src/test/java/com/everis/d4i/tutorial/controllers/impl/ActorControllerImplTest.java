package com.everis.d4i.tutorial.controllers.impl;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.d4i.tutorial.services.ActorService;

@RunWith(SpringRunner.class)
class ActorControllerImplTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ActorService actorServiceMock;
	
	@Test
	void test() throws Exception {
		RequestBuilder request= MockMvcRequestBuilders
				.get("/netflix/v1/netflix/v1/actor/1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result= mockMvc.perform(request).andReturn();
		
	}

}

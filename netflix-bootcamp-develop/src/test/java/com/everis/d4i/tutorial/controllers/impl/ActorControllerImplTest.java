package com.everis.d4i.tutorial.controllers.impl;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.d4i.tutorial.json.ActorDataRest;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.RestConstants;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ActorControllerImplTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ActorService actorService;
	
	private final String REQ_SUCCESS = "\"status\": \"Success\"," + "\"code\": \"200 OK\"," + "\"message\": \"OK\",";

	@Test
    public void getAllActorsTest() throws Exception {


 

        List<ActorDataRest> salida = new ArrayList<>();
        salida.add(new ActorDataRest(1L, "Actor1", "Actor1S"));
        salida.add(new ActorDataRest(2L, "Actor2", "Actor2S"));

 

        Mockito.when(actorService.getAllActorsData()).thenReturn(salida);

 

        final RequestBuilder request = MockMvcRequestBuilders
                .get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTOR)
                .accept(MediaType.APPLICATION_JSON);

 

        mockMvc.perform(request).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json("{" + REQ_SUCCESS + "\"data\": [" + "{" + "\"id\": 1,"
                        + "\"name\": \"Actor1\"," + "\"lastName\": \"Actor1S\"" + "}," + "{" + "\"id\": 2,"
                        + "\"name\": \"Actor2\"," + "\"lastName\": \"Actor2S\"" + "}" + "]}"))
                .andReturn();

 

    }

}

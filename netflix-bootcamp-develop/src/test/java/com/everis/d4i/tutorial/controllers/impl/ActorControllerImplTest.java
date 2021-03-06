//package com.everis.d4i.tutorial.controllers.impl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.everis.d4i.tutorial.exceptions.NotFoundException;
//import com.everis.d4i.tutorial.json.ActorDataRest;
//import com.everis.d4i.tutorial.services.ActorService;
//import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;
//import com.everis.d4i.tutorial.utils.constants.RestConstants;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//class ActorControllerImplTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private ActorService actorService;
//
//	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
//			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//
//	private final String REQ_SUCCESS = "\"status\": \"Success\"," + "\"code\": \"200 OK\"," + "\"message\": \"OK\",";
//
//	@Test
//	public void getAllActorsTest() throws Exception {
//
//		List<ActorDataRest> salida = new ArrayList<>();
//		salida.add(new ActorDataRest(1L, "Actor1", "Actor1S", (short) 25, "Espa??a"));
//		salida.add(new ActorDataRest(2L, "Actor2", "Actor2S", (short) 25, "Espa??a"));
//
//		Mockito.when(actorService.getAllActorsData()).thenReturn(salida);
//
//		final RequestBuilder request = MockMvcRequestBuilders
//				.get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTOR)
//				.accept(MediaType.APPLICATION_JSON);
//
//		mockMvc.perform(request).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().json("{" + REQ_SUCCESS + "\"data\": [" + "{" + "\"id\": 1,"
//						+ "\"name\": \"Actor1\"," + "\"lastName\": \"Actor1S\"" + "}," + "{" + "\"id\": 2,"
//						+ "\"name\": \"Actor2\"," + "\"lastName\": \"Actor2S\"" + "}" + "]}"))
//				.andReturn();
//	}
//
//	@Test
//	public void addActorTest() throws Exception {
//
//		ActorDataRest actorRest = new ActorDataRest();
//		actorRest.setId(1L);
//		actorRest.setName("Jose");
//		actorRest.setLastName("Palacios");
//		actorRest.setAge((short) 24);
//		actorRest.setNationality("Espa??a");
//
//		Mockito.when(actorService.addActor(actorRest)).thenReturn(actorRest);
//
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		String requestJson = ow.writeValueAsString(actorRest);
//
//		final RequestBuilder request = MockMvcRequestBuilders
//				.post(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTOR)
//				.contentType(APPLICATION_JSON_UTF8).content(requestJson).accept(MediaType.APPLICATION_JSON);
//
//		mockMvc.perform(request).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().json("{" + REQ_SUCCESS + "\"data\": " + "{" + "\"id\": 1," + "\"name\": \"Jose\","
//						+ "\"lastName\": \"Palacios\"," + "\"age\": 24," + "\"nationality\": \"Espa??a\"" + "}" + "}"))
//				.andReturn();
//	}
//
//	@Test
//	public void deleteActor() throws Exception {
//
//		Mockito.when(actorService.deleteActor(1L)).thenReturn("Actor eliminado");
//
//		final RequestBuilder request = MockMvcRequestBuilders.delete(RestConstants.APPLICATION_NAME
//				+ RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTOR + RestConstants.RESOURCE_ID, 1L);
//
//		mockMvc.perform(request).andExpect(status().isOk());
//
//	}
//
//	@Test
//	public void updateActor() throws Exception {
//
//		ActorDataRest actorRest = new ActorDataRest();
//		actorRest.setId(1L);
//		actorRest.setName("Jose");
//		actorRest.setLastName("Palacios");
//		actorRest.setAge((short) 24);
//		actorRest.setNationality("Espa??a");
//
//		Mockito.when(actorService.updateActor(1L, actorRest)).thenReturn(actorRest);
//
//		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//		String requestJson = ow.writeValueAsString(actorRest);
//
//		final RequestBuilder request = MockMvcRequestBuilders.put(RestConstants.APPLICATION_NAME
//				+ RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ACTOR + RestConstants.RESOURCE_ID, 1L)
//				.content(requestJson).contentType(MediaType.APPLICATION_JSON);
//
//		mockMvc.perform(request).andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("Jose"));
//
//	}
//	
//	  @Test
//	    public void getActorNegativeCase() throws Exception {
//	        Long id = 28L;
//
//	        Mockito.when(actorService.getActor(id)).thenThrow(new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ACTOR));
//
//	        RequestBuilder request = MockMvcRequestBuilders.get("/netflix/v1/actor/" + id).param("id", id.toString());
//
//	        mockMvc.perform(request).andDo(print()).andExpect(status().isNotFound())
//	                .andExpect(content().json("{\r\n" + "  \"status\": \"ERROR\",\r\n" + "  \"code\": \"404\",\r\n"
//	                        + "  \"message\": \"No existe el actor\",\r\n" + "  \"data\": []\r\n"
//	                        + "}"));
//	    }
//
//}

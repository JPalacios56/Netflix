package com.everis.d4i.tutorial.controllers.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.d4i.tutorial.json.CategoryRest;
import com.everis.d4i.tutorial.services.CategoryService;
import com.everis.d4i.tutorial.utils.constants.RestConstants;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class CategoryControllerImplTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService categoryService;

	public final String REQ_SUCCESS = "\"status\": \"Success\"," + "\"code\": \"200 OK\"," + "\"message\": \"OK\",";

	@Test
	void getCategoriesTest() throws Exception {
		
		List<CategoryRest> salida= new ArrayList<>();
		salida.add(new CategoryRest(1L,"Categoría 1"));
		salida.add(new CategoryRest(2L,"Categoría 2"));
		

		Mockito.when(categoryService.getCategories())
				.thenReturn(salida);

		
		final RequestBuilder request = MockMvcRequestBuilders
				.get(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CATEGORY + "/")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("{" + REQ_SUCCESS + "\"data\": [" 
				+ "{"+ "\"id\": 1," + "\"name\": \"Categoría 1\""+ "}," 
				+ "{"+ "\"id\": 2," + "\"name\": \"Categoría 2\"" + "}" + "]}"))
				.andReturn();
	}
}
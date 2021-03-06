//package com.everis.d4i.tutorial.services.impl;
//
//import static org.junit.jupiter.api.Assertions.*;
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
//import com.everis.d4i.tutorial.entities.Category;
//import com.everis.d4i.tutorial.entities.TvShow;
//import com.everis.d4i.tutorial.exceptions.NetflixException;
//import com.everis.d4i.tutorial.json.CategoryRest;
//import com.everis.d4i.tutorial.repositories.CategoryRepository;
//
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class CategoryServiceImplTest {
//
//	@Mock
//	private CategoryRepository categoryRepository;
//	
//	@InjectMocks
//	private CategoryServiceImpl categoryService;
//
//
//	@Test
//	void testGetCategories() throws NetflixException {
//
//		Mockito.when(categoryRepository.findAll())
//		.thenReturn(Lists.list(new Category(1L, "Terror",Lists.list(new TvShow())),
//				new Category(2L, "Comedia",Lists.list(new TvShow()))));
//		
//		List <CategoryRest> categories= categoryService.getCategories();
//		
//		assertEquals((long) 1L,categories.get(0).getId());
//		assertEquals("Comedia",categories.get(1).getName());
//	}
//	
//	@Test
//	void testCreateCategories() throws NetflixException{
//		
//		CategoryRest categoryRest = new CategoryRest();
//		categoryRest.setName("Animacion");
//		
//		Category category= new Category();
//		category.setName("Animacion");
//				
//		Mockito.when(categoryRepository.save(Mockito.any(Category.class)))
//		.thenReturn(category);
//		
//		CategoryRest categoryAdd = categoryService.createCategories(categoryRest);
//		assertEquals(categoryAdd.getName(), "Animacion");
//	}
//
//}

package com.niit.gotoHotelBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.gotoHotelBackend.dao.CategoryDao;
import com.niit.gotoHotelBackend.dto.CategoryDto;

public class CategoryDtoTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private CategoryDto categoryDto;
	
	@BeforeClass
	public static void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.gotoHotelBackend");
	context.refresh();
	categoryDao = (CategoryDao)context.getBean("categoryDao");
	}
	/*
	 * @Test
	public void testAddCategory(){
		categoryDto = new CategoryDto();
		
		categoryDto.setName("5 star");
		categoryDto.setProduct_id(1);
		categoryDto.setPrice(1000);
		categoryDto.isActive();
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(categoryDto));
	}
	*/
	
	/*@Test
	public void testGetCategory(){
		categoryDto = new CategoryDto();
		categoryDto = categoryDao.get(3);
		assertEquals("Successfully fetched a single category from the table!","5 star",categoryDto.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		categoryDto = new CategoryDto();
		categoryDto = categoryDao.get(3);
		
		categoryDto.setName("affordable");
		
		assertEquals("Successfully update a single category in the table!",true,categoryDao.update(categoryDto));
}*/
	
	/*@Test
	public void testDeleteCategory(){
		categoryDto = new CategoryDto();
		categoryDto = categoryDao.get(3);
		
		assertEquals("Successfully delete a single category in the table!",true,categoryDao.delete(categoryDto));
}*/
	
	@Test
	public void testListCategory(){
		
		assertEquals("Successfully fetched a list of category from the table!",1,categoryDao.list().size());
	}

}


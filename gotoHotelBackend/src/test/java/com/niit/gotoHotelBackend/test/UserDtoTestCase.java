package com.niit.gotoHotelBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.UserDto;

public class UserDtoTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private UserDto userDto;
	
	@BeforeClass
	public static void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.gotoHotelBackend");
	context.refresh();
	userDao = (UserDao)context.getBean("userDao");
	}
	 
	
	/*@Test
	public void testAddServices(){
		userDto = new UserDto();
		
		userDto.setAddress("delhi");
		userDto.setUserId(1);
	    userDto.setState("haryana");
		userDto.setCity("faridabad");
		userDto.setEmail("chirag.singla8802@gmail.com");
		userDto.setName("chirag");
		userDto.setPassword("chirag1234");
		userDto.setPhoneNo("8802");
		userDto.setActive(true);
		assertEquals("Successfully added a product inside the table!",true,userDao.add(userDto));
	}*/
	
	/*@Test
	public void testGetServices(){
		userDto = new UserDto();
		userDto = userDao.getUserDetail(1);
		assertEquals("Successfully fetched a single category from the table!","chirag",userDto.getName());
	}*/
	
	/*@Test
	public void testUpdateServices(){
		userDto = new UserDto();
		userDto = userDao.getUserDetail(1);
		
		userDto.setCity("ballabgarh");
		
		assertEquals("Successfully update a single category in the table!",true,userDao.update(userDto));
}*/
	
	/*@Test
	public void testDeletServices(){
		userDto = new UserDto();
		userDto = userDao.getUserDetail(1);
		
		assertEquals("Successfully delete a single category in the table!",true,userDao.delete(1));
}*/
	
	/*@Test
	public void testListServices(){
		
		assertEquals("Successfully fetched a list of services from the table!",1,userDao.userlist().size());
	}
	*/
}

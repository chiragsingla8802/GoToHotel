package com.niit.gotoHotelBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dto.ServicesDto;

public class ServicesDtoTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ServicesDao servicesDao;
	private ServicesDto servicesDto;
	
	@BeforeClass
	public static void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.gotoHotelBackend");
	context.refresh();
	servicesDao = (ServicesDao)context.getBean("servicesDao");
	}
//	 @Test
//	public void testAddServices(){
//		servicesDto = new ServicesDto();
//		
//		servicesDto.setPId(1);
//		servicesDto.setPrice(1000);
//		servicesDto.isActive();
//		servicesDto.setLocation("Delhi");
//		servicesDto.setDescription("5 star hotels");
//		
//		assertEquals("Successfully added a product inside the table!",true,servicesDao.add(servicesDto));
//	}
	
	/*@Test
	public void testGetServices(){
		servicesDto = new ServicesDto();
		servicesDto = servicesDao.get(33);
		assertEquals("Successfully fetched a single category from the table!","Delhi",servicesDto.getLocation());
	}*/
	
	/*@Test
	public void testUpdateServices(){
		servicesDto = new ServicesDto();
		servicesDto = servicesDao.get(33);
		
		servicesDto.setLocation("Faridabad");
		
		assertEquals("Successfully update a single category in the table!",true,servicesDao.update(servicesDto));
}*/
	
	/*@Test
	public void testDeletServices(){
		servicesDto = new ServicesDto();
		servicesDto = servicesDao.get(33);
		
		assertEquals("Successfully delete a single category in the table!",true,servicesDao.delete(33));
}
	*/
	/*@Test
	public void testListServices(){
		
		assertEquals("Successfully fetched a list of services from the table!",1,servicesDao.list().size());
	}
	*/
	
}

package com.niit.gotoHotelBackend.dao;

import java.util.List;
import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dto.ServicesDto;

public interface ServicesDao 
{
	boolean add(ServicesDto servicesDto);
	boolean delete(ServicesDto servicesDto);
	boolean update(ServicesDto servicesDto);
		
	List<ServicesDto> list();	
	ServicesDto get(int category_id);
}

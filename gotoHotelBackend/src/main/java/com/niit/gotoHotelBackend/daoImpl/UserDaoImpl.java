package com.niit.gotoHotelBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.UserDto;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	  
	  
	
	

	@Override
	public boolean add(UserDto userDto) {
		try {
			// add the category to database table
			sessionFactory.getCurrentSession().save(userDto);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		UserDto userDto = this.getUserDetail(id);
		userDto.setActive(false);
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(userDto);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
	}}


	@Override
	public boolean update(UserDto userDto) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(userDto);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<UserDto> userlist() {
		return sessionFactory.getCurrentSession().createQuery("FROM UserDto WHERE active = TRUE").list();
	}

	@Override
	public UserDto getUserDetail(int userId) {
		return sessionFactory.getCurrentSession().get(UserDto.class, Integer.valueOf(userId)); 
	}

	@Override
	public UserDto getUserDetailByName(String name) {
		return sessionFactory.getCurrentSession().get(UserDto.class, String.valueOf(name)); 
	}
}
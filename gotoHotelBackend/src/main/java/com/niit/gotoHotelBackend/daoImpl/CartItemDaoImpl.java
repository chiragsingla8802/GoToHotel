package com.niit.gotoHotelBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gotoHotelBackend.dao.CartItemDao;
import com.niit.gotoHotelBackend.dto.CartItem;
import com.niit.gotoHotelBackend.dto.UserDto;
@Repository("userDao")
@Transactional
public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean add(CartItem cartItem) {
		try {
			// add the category to database table
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		CartItem cartItem = this.getUserDetail(id);
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
	}
	}

	@Override
	public boolean update(CartItem cartItem) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CartItem> userlist() {
		return sessionFactory.getCurrentSession().createQuery("FROM CartItem WHERE active = TRUE").list();
	}

	@Override
	public CartItem getUserDetail(int userId) {
		return sessionFactory.getCurrentSession().get(CartItem.class, Integer.valueOf(userId)); 
	}

	@Override
	public CartItem getUserDetailByName(String name) {
		return sessionFactory.getCurrentSession().get(CartItem.class, String.valueOf(name)); 
	}

}

package com.niit.gotoHotelBackend.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gotoHotelBackend.dao.CartDao;
import com.niit.gotoHotelBackend.dto.Cart;
@Repository("CartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(Cart cart) {
		try {
			// add the category to database table
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Cart cart) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Cart> userlist() {
		return sessionFactory.getCurrentSession().createQuery("FROM Cart WHERE active = TRUE").list();
	}

	@Override
	public Cart getUserDetail(int cartId) {
		
		return sessionFactory.getCurrentSession().get(Cart.class, Integer.valueOf(cartId)); 
	}

	@Override
	public Cart getUserDetailByid(int userId) {
		Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, userId);
}}
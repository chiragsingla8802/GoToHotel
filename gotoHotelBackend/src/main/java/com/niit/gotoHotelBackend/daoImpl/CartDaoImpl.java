package com.niit.gotoHotelBackend.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.gotoHotelBackend.dao.CartDao;
import com.niit.gotoHotelBackend.dto.Cart;
import com.niit.gotoHotelBackend.dto.CartItem;

//@Repository,stereotype for persistence layer (used to get data from database)
//@Transactional, Spring dynamically creates a proxy that implements the same interface(s) as the class you're annotating. And when clients make calls into your object, the calls are intercepted and the behaviors injected via the proxy mechanism.
@Repository("CartDao")
@Transactional
public class CartDaoImpl implements CartDao {

	// The @Autowired annotation can be used to autowire bean on the setter
	// method

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
	}

	@Override
	public CartItem getCartItem(int id, int cartId) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM CartItem WHERE CartId ='" + cartId + "' AND UserId ='" + id + "'", CartItem.class)
				.getSingleResult();

	}

	@Override
	public CartItem addCartItem(CartItem cartItem) {
		sessionFactory.getCurrentSession().persist(cartItem);
		// here we use persist because we want cart item id to auto generated
		// and return to object
		return cartItem;
	}
}
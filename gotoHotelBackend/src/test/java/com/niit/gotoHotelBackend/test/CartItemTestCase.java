package com.niit.gotoHotelBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.gotoHotelBackend.dao.CartDao;
import com.niit.gotoHotelBackend.dao.CartItemDao;
import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.Cart;
import com.niit.gotoHotelBackend.dto.CartItem;
import com.niit.gotoHotelBackend.dto.ServicesDto;
import com.niit.gotoHotelBackend.dto.UserDto;

public class CartItemTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static CartItemDao cartItemDao;
	private static CartDao cartDao;
	private static UserDao userDao;

	private static ServicesDao servicesDao;
	
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.gotoHotelBackend");
		context.refresh();
		cartItemDao = (CartItemDao)context.getBean("CartItemDao");
		cartDao=(CartDao)context.getBean("CartDao");
		userDao = (UserDao)context.getBean("userDao");
		servicesDao = (ServicesDao)context.getBean("servicesDao");

	}

	/*@Test
	public void testListCartItem(){
		
		// get the user
		UserDto userDto = userDao.getUserDetail(1);
		// get the cart
		Cart cart = cartDao.getUserDetail(7);
		// get the cartItems
		
		assertEquals("List CartItem fetched Successfully!",0,cartItemDao.userlist().size());
		
	}*/

	
	// Adding a new cartItem
/*@Test
	public void testAddCartItem() {
		
		// get the user
		UserDto userDto = userDao.getUserDetail(1);
		// get the cart
		Cart cart = userDto.getCart();

		// get the product
		ServicesDto servicesDto = servicesDao.get(70);
		
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setServicesDto(servicesDto);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());
	
		cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
		cart.setCartItemsCount(cart.getCartItemsCount() + 1);
		assertEquals("Successfully added the cart item!",true, cartItemDao.add(cartItem));
		
		
	}*/


	// updating the existing cart item
	/*@Test
	public void testUpdateCartItem() {
				
		CartItem cartItem = cartItemDao.getUserDetail(1);
		
		Cart cart = cartItem.getCart();
		
		ServicesDto servicesDto = cartItem.getServicesDto();
		
		int oldQuantity = cartItem.getQuantity();

		cartItem.setQuantity(cartItem.getQuantity() + 1);
		
		cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getQuantity() - oldQuantity) * servicesDto.getPrice());
		
		assertEquals("Successfully updated the cart item!",true, cartItemDao.update(cartItem));

		//assertEquals("Successfully updated the cart item!",true, cartItemDAO.updateCart(cart));

		
	}*/}

	


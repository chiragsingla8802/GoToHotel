package com.niit.gotoHotelBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.gotoHotelBackend.dao.CartItemDao;
import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.Cart;
import com.niit.gotoHotelBackend.dto.UserDto;

public class CartItemTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static CartItemDao cartItemDao;

	private static UserDao userDao;

	private static ServicesDao servicesDao;
	
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		cartItemDao = (CartItemDao)context.getBean("cartItemDao");
		userDao = (UserDao)context.getBean("userDao");
		servicesDao = (ServicesDao)context.getBean("servicesDao");

	}

	
	@Test
	public void testListCartItem(){
		
		// get the user
		UserDto userDto = userDao.getUserDetail(2);
		// get the cart
		Cart cart = userDto.getCart();
		// get the cartItems
		
		assertEquals("List CartItem fetched Successfully!",0,cartItemDao.userlist().size());
		
	}

	
	// Adding a new cartItem
/*	@Test
	public void testAddCartItem() {
		
		// get the user
		User user = userDAO.get(2);
		// get the cart
		Cart cart = user.getCart();

		// get the product
		Product product = productDAO.get(1);
		
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(2);
		cartItem.setTotalPrice(product.getUnitPrice() * cartItem.getQuantity());
	
		cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
		cart.setCartItemsCount(cart.getCartItemsCount() + 1);
		assertEquals("Successfully added the cart item!",true, cartItemDAO.add(cartItem));
		
		
	}
*/	

	// updating the existing cart item
	/*@Test
	public void testUpdateCartItem() {
				
		CartItem cartItem = cartItemDAO.get(7);
		
		Cart cart = cartItem.getCart();
		
		Product product = cartItem.getProduct();
		
		int oldQuantity = cartItem.getQuantity();

		cartItem.setQuantity(cartItem.getQuantity() + 1);
		
		cartItem.setTotalPrice(product.getUnitPrice() * cartItem.getQuantity());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getQuantity() - oldQuantity) * product.getUnitPrice());
		
		assertEquals("Successfully updated the cart item!",true, cartItemDAO.update(cartItem));*/

		//assertEquals("Successfully updated the cart item!",true, cartItemDAO.updateCart(cart));

		
	}

	


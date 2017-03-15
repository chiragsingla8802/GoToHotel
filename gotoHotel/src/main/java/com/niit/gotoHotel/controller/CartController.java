package com.niit.gotoHotel.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gotoHotelBackend.dao.CartDao;
import com.niit.gotoHotelBackend.dao.CartItemDao;
import com.niit.gotoHotelBackend.dao.ServicesDao;
import com.niit.gotoHotelBackend.dao.UserDao;
import com.niit.gotoHotelBackend.dto.Cart;
import com.niit.gotoHotelBackend.dto.CartItem;
import com.niit.gotoHotelBackend.dto.ServicesDto;
import com.niit.gotoHotelBackend.dto.UserDto;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	CartItemDao cartItemDao;

	@Autowired
	ServicesDao servicesDao;

	@Autowired
	UserDao userDao;
	
	  @Autowired 
	  CartDao cartDao;
	 

	/*
	 * @RequestMapping(value="/cartItem") public ModelAndView cart(Principal
	 * principal){ ModelAndView mv =new ModelAndView("index"); UserDto
	 * userDto=userDao.getUserDetailByName(principal.getName());
	 * System.out.println("----------------------------------"+userDto.getEmail(
	 * )+"-----------------------------"); Cart cart=userDto.getCart();
	 * mv.addObject("servicesDto",servicesDao.get(userDto.getUserId()));
	 * mv.addObject("cartItem", cartItemDao.userlist(cart));
	 * mv.addObject("cart",cart); mv.addObject("userClickCart","true"); return
	 * mv; }
	 */

	@RequestMapping("/{id}")
	public ModelAndView getCart(@PathVariable(value = "id") int id, Principal principal) {
		ModelAndView mv = new ModelAndView("index");

		UserDto userDto = userDao.getUserDetailByName(principal.getName());
		System.out.println("----------------------------------" + userDto.getEmail() + "-----------------------------");
		ServicesDto servicesDto = servicesDao.get(id);

		CartItem cartItem = new CartItem();

		Cart cart = userDto.getCart();

		cartItem.setQuantity(cartItem.getQuantity() + 1);

		double itemprice = servicesDto.getPrice();

		System.out.println("----------------------------------" + itemprice + "-----------------------------");

		double totalPrice = itemprice * cartItem.getQuantity();

		System.out.println(
				"----------------------------------" + cartItem.getQuantity() + "-----------------------------");

		int quantity = cartItem.getQuantity();

		System.out.println("----------------------------------" + totalPrice + "-----------------------------");

		cartItem.setTotalPrice(totalPrice);

		double grandTotal = cart.getGrandTotal();

		System.out.println("----------------------------------" + grandTotal + "-----------------------------");

		grandTotal += totalPrice;

		System.out.println("----------------------------------" + grandTotal + "-----------------------------");

		cart.setGrandTotal(grandTotal);

		int items = cart.getCartItemsCount();

		System.out.println("----------------------------------" + items + "-----------------------------");

		items += 1;

		System.out.println("----------------------------------" + items + "-----------------------------");

		cart.setCartItemsCount(items);

		cartItem.setCart(cart);

		cartItem.setServicesDto(servicesDao.get(id));

		cartItemDao.add(cartItem);

		cartItemDao.update(cartItem);

		mv.addObject("servicesDto", new ServicesDto());

		mv.addObject("list", servicesDao.get(userDto.getUserId()));

		int cartId = userDto.getCart().getCartId();

		mv.addObject("userClickCart", "true");

		mv.addObject("cartItem", cartItemDao.userlist(cart));

		mv.addObject("cart", cart);

		return mv;
	}

	  
	/*  
	  @RequestMapping("/showCart")
	  public String showCart(Model model) {
	  cart = cartDao.getCart(userDto.getUserId);
	  List<CartItem> cartItems = new ArrayList<>();
	  cartItems = cartDao.getCartItemList();
	  List<CartItem> cartIter = new ArrayList<>();
	  for (CartItem car : cartItems) {
	  car.setProduct(servicesDao.getId(car.getCartItemId()));
	  cartIter.add(car);
	      }
	  for (CartItem car : cartIter) {
	  System.out.println("Cart List : Name - " + car.getProduct().getpName());
	     }
	  model.addAttribute("cartDetails", cart);
	  model.addAttribute("cart", cartIter);
	  return "cart";
	  	}
*/
	  
	  
	  
	  
	@RequestMapping("/update/{id}")
	public ModelAndView updateCart(@PathVariable(value = "id") int id, Principal principal) {
		ModelAndView mv = new ModelAndView("index");

		System.out.println("----------------------------------id reached" + id + "-----------------------------");
		
		UserDto userDto = userDao.getUserDetailByName(principal.getName());

		System.out.println("----------------------------------getEmail reached" + userDto.getEmail()+ "-----------------------------");

		ServicesDto servicesDto = servicesDao.get(id);

		System.out.println("------------------------------------services id reached" + servicesDao.get(id)+ "---------------------");

			
		CartItem cartItem = cartItemDao.getUserDetail(userDto.getUserId());

		System.out.println("----------------------------user detail id reached"+cartItemDao.getUserDetail(userDto.getUserId()) +"----------------------");

		Cart cart = cartItem.getCart();

		if(cartItem.getQuantity()!= 0){
			if(cartItem.getServicesDto().getId() == servicesDto.getId()){
				cartItem = cartDao.getCartItem(servicesDto.getId(), cart.getCartId());
				int oldQuantity = cartItem.getQuantity();
				cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getQuantity() - oldQuantity) * servicesDto.getPrice());
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());
				cartItemDao.update(cartItem);
			}}
		
		/*	else{
		int oldQuantity = cartItem.getQuantity();

		System.out.println("------------------------------" + oldQuantity + "-------------------------");

		cartItem.setQuantity(cartItem.getQuantity() + 1);

		System.out.println("------------------------------" + cartItem.getQuantity() + "-------------------------");

		cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());

		System.out.println("------------------------------" + cartItem.getTotalPrice() + "-------------------------");

		cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getQuantity() - oldQuantity) * servicesDto.getPrice());

		System.out.println("------------------------------" + cart.getGrandTotal() + "-------------------------");

		cartItemDao.update(cartItem);}
*/
		mv.addObject("userClickCart", "true");

		mv.addObject("cartItem", cartItemDao.userlist(cart));

		mv.addObject("cart", cart);

		return mv;
		}
	
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteCart(@PathVariable(value = "id") int id, Principal principal) {

		ModelAndView mv = new ModelAndView("index");

		System.out.println("----------------------------------id reached" + id + "-----------------------------");

		UserDto userDto = userDao.getUserDetailByName(principal.getName());

		System.out.println("----------------------------------getEmail reached" + userDto.getEmail()
				+ "-----------------------------");

		ServicesDto servicesDto = servicesDao.get(id);

		System.out.println("------------------------------------services id reached" + servicesDao.get(id)
				+ "---------------------");

		CartItem cartItem = cartItemDao.getUserDetail(userDto.getUserId());

		System.out.println("----------------------------user detail id reached"
				+ cartItemDao.getUserDetail(userDto.getUserId()) + "----------------------");

		Cart cart = cartItem.getCart();

		int oldQuantity = cartItem.getQuantity();

		System.out.println(
				"------------------------------old quantity reached" + oldQuantity + "-------------------------");

		cartItem.setQuantity(cartItem.getQuantity() - 1);

		System.out.println("------------------------------new quantity reached" + cartItem.getQuantity()
				+ "-------------------------");

		cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());

		System.out.println("------------------------------total price reached" + cartItem.getTotalPrice()
				+ "-------------------------");

		cart.setGrandTotal(cart.getGrandTotal() - (oldQuantity - cartItem.getQuantity()) * servicesDto.getPrice());

		System.out.println("------------------------------grand total reached" + cart.getGrandTotal()
				+ "-------------------------");

		if (cartItem.getQuantity() == 1) {

			cartItemDao.delete(cartItem);
		}

		else {
			cartItemDao.update(cartItem);
		}

		mv.addObject("userClickCart", "true");

		mv.addObject("cartItem", cartItemDao.userlist(cart));

		mv.addObject("cart", cart);

		return mv;

	}

	@RequestMapping("/payment")
	public ModelAndView payment() {
		// System.out.println(prin.getName());
		ModelAndView mv = new ModelAndView("index");
		// mv.addObject("title", "Home");
		mv.addObject("userClickPayment", true);
		// mv.addObject("cartItem", cartItemDao.userlist(cart));
		return mv;
	}

	@RequestMapping("/finalInvoice")
	public ModelAndView finalInvoice() {
		// System.out.println(prin.getName());
		ModelAndView mv = new ModelAndView("index");
		// mv.addObject("title", "Home");
		mv.addObject("userClickFinalInvoice", true);
		// mv.addObject("cartItem", cartItemDao.userlist(cart));
		return mv;
	}
	/*
	 * // mapping for contact us page
	 * 
	 * @RequestMapping(value = "/{id}") public ModelAndView
	 * cart(@PathVariable("id") int cartId){ ModelAndView mv = new
	 * ModelAndView("index"); mv.addObject("title", "Cart");
	 * mv.addObject("userClickCart", true);
	 * mv.addObject("cartItem",cartItemDao.userlist()); return mv; }
	 * 
	 * 
	 * @RequestMapping(value = "/add/{id}", method = RequestMethod.PUT) public
	 * ModelAndView addItem (@PathVariable(value="id") int
	 * id, @AuthenticationPrincipal User activeUser){ ModelAndView mv = new
	 * ModelAndView("index"); UserDto userDto = userDao.getUserDetail(id); Cart
	 * cart = userDto.getCart(); ServicesDto servicesDto = servicesDao.get(id);
	 * List<CartItem> cartItems = cart.getCartItems(); for (int i=0; i <
	 * cartItems.size(); i++){ if(servicesDto.getId() ==
	 * cartItemDao.getUserDetail(id).getServicesDto().getId()){ CartItem
	 * cartItem = cartItems.get(i);
	 * cartItem.setQuantity(cartItem.getQuantity()+1);
	 * cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());
	 * cartItemDao.add(cartItem);}} return mv;
	 * 
	 * }
	 * 
	 * 
	 */

	/*
	 * List<CartItem> cartItems = cart.getCartItems();
	 * 
	 * for (int i=0; i < cartItems.size(); i++){ if(servicesDto.getId() ==
	 * cartItem.get(i).getServicesDto().getId()){ CartItem cartItem =
	 * cartItems.get(i); cartItem.setQuantity(cartItem.getQuantity() + 1);
	 * cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
	 * cartItemService.addCartItem(cartItem);
	 * 
	 * return mv; } }
	 */

	/*
	 * @RequestMapping(value="/addToCart/{userId}/{id}") public ModelAndView
	 * addCart(@PathVariable("userId")int userId,@PathVariable("id")int id){
	 * ModelAndView mv = new ModelAndView("index"); mv.addObject("title",
	 * "Cart"); mv.addObject("userClickCart", true); UserDto userDto =
	 * userDao.getUserDetail(userId); Cart cart = userDto.getCart(); ServicesDto
	 * servicesDto = servicesDao.get(id); CartItem cartItem = new CartItem();
	 * cartItem.setCart(cart); cartItem.setServicesDto(servicesDto);
	 * cartItem.setQuantity(cartItem.getQuantity()+1);
	 * cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());
	 * cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
	 * cart.setCartItemsCount(cart.getCartItemsCount() + 1);
	 * cartItemDao.add(cartItem); return mv; }
	 */

	/*
	 * 
	 * 
	 * @RequestMapping("/{cartId}") public @ResponseBody Cart
	 * getCartById(@PathVariable(value = "cartId") int cartId){ return
	 * cartService.getCartById(cartId); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	 * 
	 * @ResponseStatus(value = HttpStatus.NO_CONTENT) public void addItem
	 * (@PathVariable(value = "productId") int
	 * productId, @AuthenticationPrincipal User activeUser){ Customer customer =
	 * customerService.getCustomerByUsername(activeUser.getUsername()); Cart
	 * cart = customer.getCart(); Product product =
	 * productService.getProductById(productId); List<CartItem> cartItems =
	 * cart.getCartItems();
	 * 
	 * for (int i=0; i < cartItems.size(); i++){ if(product.getProductId() ==
	 * cartItems.get(i).getProduct().getProductId()){ CartItem cartItem =
	 * cartItems.get(i); cartItem.setQuantity(cartItem.getQuantity() + 1);
	 * cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
	 * cartItemService.addCartItem(cartItem);
	 * 
	 * return; } }
	 * 
	 * CartItem cartItem = new CartItem(); cartItem.setProduct(product);
	 * cartItem.setQuantity(1);
	 * cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
	 * cartItem.setCart(cart); cartItemService.addCartItem(cartItem); }
	 * 
	 * @RequestMapping(value = "/remove/{productId}", method =
	 * RequestMethod.PUT)
	 * 
	 * @ResponseStatus(value = HttpStatus.NO_CONTENT) public void
	 * removeItem(@PathVariable(value = "productId") int productId){ CartItem
	 * cartItem = cartItemService.getCartItemByProductId(productId);
	 * cartItemService.removeCartItem(cartItem);
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	 * 
	 * @ResponseStatus(value = HttpStatus.NO_CONTENT) public void
	 * clearCart(@PathVariable(value = "cartId") int cartId){ Cart cart =
	 * cartService.getCartById(cartId);
	 * cartItemService.removeAllCartItems(cart); }
	 * 
	 * @ExceptionHandler(IllegalArgumentException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason =
	 * "Illegal request, please verify your payload") public void
	 * handleClientErrors (Exception ex){
	 * 
	 * }
	 * 
	 * @ExceptionHandler(Exception.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason =
	 * "Internal Server Error") public void handleServerErrors (Exception ex){
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = "/cart/addToCart") public ModelAndView addcart()
	 * { ModelAndView mv = new ModelAndView("index"); mv.addObject("title",
	 * "Cart"); mv.addObject("userClickCart", true); UserDto userDto =
	 * userDao.getUserDetail(userId); Cart cart = userDto.getCart(); cartItemDao
	 * ServicesDto servicesDto = servicesDao.; cartItem.setCart(cart);
	 * cartItem.setServicesDto(servicesDto); cartItem.setQuantity(1);
	 * cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());
	 * 
	 * cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
	 * cart.setCartItemsCount(cart.getCartItemsCount() + 1);
	 * cartItemDao.add(cartItem); return mv; }
	 */
	// get the user
	/*
	 * UserDto userDto = userDao.getUserDetail(1); // get the cart Cart cart =
	 * userDto.getCart();
	 * 
	 * // get the product ServicesDto servicesDto = servicesDao.get(70);
	 * 
	 * CartItem cartItem = new CartItem(); cartItem.setCart(cart);
	 * cartItem.setServicesDto(servicesDto); cartItem.setQuantity(1);
	 * cartItem.setTotalPrice(servicesDto.getPrice() * cartItem.getQuantity());
	 * 
	 * cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
	 * cart.setCartItemsCount(cart.getCartItemsCount() + 1); assertEquals(
	 * "Successfully added the cart item!",true, cartItemDao.add(cartItem));
	 * 
	 */

	/*
	 * @RequestMapping public String getCart(@AuthenticationPrincipal User
	 * activeUser){ Customer customer =
	 * customerService.getCustomerByUsername(activeUser.getUsername()); int
	 * cartId = customer.getCart().getCartId();
	 * 
	 * return "redirect:/customer/cart/" + cartId; }
	 * 
	 * @RequestMapping("/{cartId}") public String getCartRedirect(@PathVariable
	 * (value = "cartId") int cartId, Model model){ model.addAttribute("cartId",
	 * cartId);
	 * 
	 * return "cart"; }
	 */

}

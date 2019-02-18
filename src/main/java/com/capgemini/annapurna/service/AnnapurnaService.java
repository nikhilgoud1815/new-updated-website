/**
 * 
 */
package com.capgemini.annapurna.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.Cart;
import com.capgemini.annapurna.restaurant.entity.EWallet;
import com.capgemini.annapurna.restaurant.entity.FoodProducts;
import com.capgemini.annapurna.restaurant.entity.Order;
import com.capgemini.annapurna.restaurant.entity.Profile;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author ugawari
 *
 */
@EnableCircuitBreaker
@Service
public class AnnapurnaService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private Restaurant restaurant;
	private Address address;
	private Cart cart;

	private Set<FoodProducts> orderProducts;

	private Integer getUniqueId() {
		UUID idOne = UUID.randomUUID();
		int uid = idOne.hashCode();
		return uid;
	}

	@HystrixCommand(fallbackMethod = "fallBackForFoodItems")
	public String getFoodItemsById(Model model, int restaurantId) {
		ResponseEntity<Restaurant> entity = restTemplate
				.getForEntity("http://annapurna-restaurant/restaurants/" + restaurantId, Restaurant.class);
		restaurant = entity.getBody();
		model.addAttribute("restaurant", entity.getBody());
		return "FoodItems";
	}

	public String fallBackForFoodItems(Model model, @RequestParam int restaurantId) {
		model.addAttribute("message", "wait for a while !");
		return "FoodItems";

	}

	@HystrixCommand(fallbackMethod = "fallBackForGetAllCarts")
	// @RequestMapping("/cart/getAll") // /cart/getAll
	public String getAllCarts(Model model) {
		System.out.println("getAll");
		ResponseEntity<List> carts = restTemplate.getForEntity("http://annapurna-cart/carts", List.class);
		model.addAttribute("carts", carts.getBody());
		return "GetAllCart";
	}

	public String fallBackForGetAllCarts(Model model) {
		model.addAttribute("message", "wait for a while !");
		return "Order";

	}
	@HystrixCommand(fallbackMethod = "fallBackForAddingIntoCart")
	public String addCart(String foodName, double price, int quantity, Model model) {
		Set<FoodProducts> products = new HashSet<FoodProducts>();
		products.add(new FoodProducts(foodName, price, quantity));
		cart = new Cart(106, restaurant.getName(), products, price, restaurant.getAddress());
		restTemplate.postForEntity("http://annapurna-cart/carts", cart, Cart.class);
		model.addAttribute("cart", cart);
		return "GetAllCart";
	}

	public String fallBackForAddingIntoCart(String foodName, @RequestParam double price,
			@RequestParam int quantity/* ,@RequestParam Address address */, Model model) {
		model.addAttribute("message", "wait for a while !");
		return "Order";

	}

	@HystrixCommand(fallbackMethod = "fallBackForGetOrderById")
	// @RequestMapping("/cart/getById")
	public String getOrderById(/* @RequestParam("orderId") */ Integer orderId, Model model) {
		ResponseEntity<Order> order = restTemplate.getForEntity("http://annapurna-order/orders/" + orderId + " ",
				Order.class);
		System.out.println(order.getBody());
		model.addAttribute("message", "heyyyyyyyy !!!!");
		model.addAttribute("Order", order.getBody());
		return "Order";
	}

	public String fallBackForGetOrderById(/* @RequestParam("orderId") */ Integer orderId, Model model) {
		model.addAttribute("message", "wait for a while !");
		return "Order";

	}

	@HystrixCommand(fallbackMethod = "fallBackForPlaceOrder")
	public String placeOrder(Address address1, Model model) {
		address = address1;
		model.addAttribute("totalAmount", cart.getTotalAmount());
		return "passMoney";
	}

	public String fallBackForPlaceOrder(Address address1, Model model) {
		model.addAttribute("message", "wait for a while !");
		return "Order";

	}

	@HystrixCommand(fallbackMethod = "fallBackForGetPlaceOrder")
	// @RequestMapping("/cart/placeOrder")
	public String getPlaceOrder(/* @RequestBody Cart cart, */Model model) {
		Set<FoodProducts> products = new HashSet<FoodProducts>();
		products.add(new FoodProducts("Brinjal", 234, 12));
		orderProducts = products;
		return "AddressForm";
	}

	public String fallBackForGetPlaceOrder(Model model) {
		model.addAttribute("message", "wait for a while !");
		return "Order";

	}

	@HystrixCommand(fallbackMethod = "passMoneyForEwallet")
	public String deduct(Double amount, Model model)
	{
		restTemplate.put("http://annapurna-ewallet/ewallets/" + 1 + "/pay?currentBalance=" + amount, null);
		model.addAttribute("message", "money deducted and Order placed Successfully!");
		String modeOfPayment = "E-Wallet"; // for now
		Double totalAmount = 100.0; // for now
		String restaurantName = "GrandMama's Cafe"; // for now
		Integer id = getUniqueId();
		Order order = new Order(id, modeOfPayment, "pending", cart.getProducts(), cart.getTotalAmount(),
				cart.getRestaurantName(), address, cart.getCartId());
		ResponseEntity<Order> order1 = restTemplate.postForEntity("http://annapurna-order/orders", order, Order.class);
		model.addAttribute("Order", order1.getBody());
		System.out.println(order1.getBody());
		return "passMoney";
	}

	public String passMoneyForEwallet(/* /@RequestParam Integer profileId, */ @RequestParam Double amount,
			Model model) {
		model.addAttribute("message", "wait for a while !");
		return "passMoney";

	}

	@HystrixCommand(fallbackMethod = "fallBackMethodForProfile")
	// @RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public String createAccount(@ModelAttribute Profile profile, Model model) {
		profile.setPassword(bCryptPasswordEncoder.encode(profile.getPassword()));
		profile.setRole("USER");
		ResponseEntity<Profile> profileEntity = restTemplate.postForEntity("http://annapurna-profile/profiless",
				profile, Profile.class);
		Profile profile2 = profileEntity.getBody();
		EWallet eWallet = new EWallet();
		eWallet.setProfileId(profile2.getProfileId());
		eWallet.setCurrentBalance(0.0);
		restTemplate.postForEntity("http://annapurna-ewallet/ewallets", eWallet, EWallet.class);
		ResponseEntity<List> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
	}

	public String fallBackMethodForProfile(Profile profile, Model model) {
		model.addAttribute("message", "wait for a while !");
		return "Home";

	}

}

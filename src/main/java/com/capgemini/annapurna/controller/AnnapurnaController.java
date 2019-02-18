/**
 * 
 */
package com.capgemini.annapurna.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.annapurna.restaurant.entity.Address;
import com.capgemini.annapurna.restaurant.entity.Cart;
import com.capgemini.annapurna.restaurant.entity.EWallet;
import com.capgemini.annapurna.restaurant.entity.FoodItem;
import com.capgemini.annapurna.restaurant.entity.FoodProducts;
import com.capgemini.annapurna.restaurant.entity.Order;
import com.capgemini.annapurna.restaurant.entity.Profile;
import com.capgemini.annapurna.restaurant.entity.Restaurant;
import com.capgemini.annapurna.restaurant.entity.Statement;
import com.capgemini.annapurna.service.AnnapurnaService;
import com.capgemini.annapurna.service.CustomUserDetailsService;

/**
 * @author ugawari
 *
 */
@EnableCircuitBreaker
@Controller
public class AnnapurnaController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private  CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private AnnapurnaService annapurnaService;
	
	
	/******** Restaurant ********/
	
	@RequestMapping("/")
	public String getAllRestaurants(Model model) {
		ResponseEntity<List> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
		//return "NewFile";
	}

	@RequestMapping("/search")
	public String search(Model model, @RequestParam String search) {
		ResponseEntity<Restaurant[]> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants",
				Restaurant[].class);
		List<Restaurant> restaurantlist = Arrays.asList(entity.getBody());
		List<Restaurant> searchedList = new ArrayList<>();
		for (Restaurant restaurant : restaurantlist) {
			if (restaurant.getName().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			if (restaurant.getAddress().getCity().equalsIgnoreCase(search))
				searchedList.add(restaurant);
			for (FoodItem foodItem : restaurant.getFoodItems()) {
				if (foodItem.getFoodName().equalsIgnoreCase(search))
					searchedList.add(restaurant);
			}
		}
		model.addAttribute("list", searchedList);
		return "Home";
	}

	private Restaurant restaurant;
	private Address address;
	private Cart cart;

	@RequestMapping("/foodItems")
	public String getFoodItemsById(Model model, @RequestParam int restaurantId) {
		/*
		 * ResponseEntity<Restaurant> entity = restTemplate
		 * .getForEntity("http://annapurna-restaurant/restaurants/" + restaurantId,
		 * Restaurant.class); restaurant = entity.getBody();
		 * model.addAttribute("restaurant", entity.getBody());
		 */
		return annapurnaService.getFoodItemsById(model, restaurantId);
	}

	/******* Login ******/
	 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	
	/******** Profile ********/
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUpPage() {
		return "AccountForm";
		//return "NewFile";
	}
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public String createAccount(@ModelAttribute Profile profile,Model model){
		/*
		 * profile.setPassword(bCryptPasswordEncoder.encode(profile.getPassword()));
		 * profile.setRole("USER"); ResponseEntity<Profile>
		 * profileEntity=restTemplate.postForEntity(
		 * "http://annapurna-profile/profiless", profile, Profile.class); Profile
		 * profile2= profileEntity.getBody(); EWallet eWallet = new EWallet();
		 * eWallet.setProfileId(profile2.getProfileId());
		 * eWallet.setCurrentBalance(0.0);
		 * restTemplate.postForEntity("http://annapurna-ewallet/ewallets", eWallet,
		 * EWallet.class); ResponseEntity<List> entity =
		 * restTemplate.getForEntity("http://annapurna-restaurant/restaurants",
		 * List.class); model.addAttribute("list", entity.getBody());
		 */
		return annapurnaService.createAccount(profile, model);
	}
	
	
	
	@RequestMapping("/cart/userProfile")
	public String features(Model model) {
		Profile profile = customUserDetailsService.getCurrentUser();
		model.addAttribute("profile", profile);
		return "UserProfile";
	}
	
	@RequestMapping("/cart/updateAccounts")
	public String updateAccounts(@RequestParam("profileId") int profileId, Model model) {
//		System.out.println("Inside update");
		System.out.println(profileId);
		ResponseEntity<Profile> profile = restTemplate.getForEntity("http://annapurna-profile/profiless/" + profileId,
				Profile.class);
		model.addAttribute("profile", profile.getBody());
		return "updateForm";
	}

	@RequestMapping("/cart/updatedform")
	public String updatedformControl(@ModelAttribute Profile profile, Model model) {
		restTemplate.put("http://annapurna-profile/profiless/" + profile.getProfileId(), profile);
		ResponseEntity<List> entity = restTemplate.getForEntity("http://annapurna-restaurant/restaurants", List.class);
		model.addAttribute("list", entity.getBody());
		return "Home";
	}
	
	@RequestMapping("/cart/gettingAccountFromId")
	public String getAccountFromId(@RequestParam("profileId") int profileId, Model model) {
		System.out.println("Inside the gettingAccountFromId");
		Profile profile = restTemplate.getForObject("http://annapurna-profile/profiless/" + profileId, Profile.class);
		// 0 System.out.println(profile.getAddress().getStreetName());
		model.addAttribute("profile", profile);
		return "ProfileDetails";
	}
	
	
	/******** Cart ********/
	
	@RequestMapping("/cart/getAll") // /cart/getAll
	public String getAllCarts(Model model) {
		/*
		 * System.out.println("getAll"); ResponseEntity<List> carts =
		 * restTemplate.getForEntity("http://annapurna-cart/carts", List.class);
		 * model.addAttribute("carts", carts.getBody());
		 */
		return annapurnaService.getAllCarts(model);
	}
	
	
	
	

	@RequestMapping("/cart/addCart")
	public String addCart(/* @RequestParam String restaurantName, */ @RequestParam String foodName,
			@RequestParam double price, @RequestParam int quantity/* ,@RequestParam Address address */, Model model) {
		/*
		 * Set<FoodProducts> products = new HashSet<FoodProducts>(); products.add(new
		 * FoodProducts(foodName, price, quantity)); cart = new Cart(106,
		 * restaurant.getName(), products, price, restaurant.getAddress());
		 * restTemplate.postForEntity("http://annapurna-cart/carts", cart, Cart.class);
		 * model.addAttribute("cart", cart);
		 */
		return annapurnaService.addCart(foodName, price, quantity, model);
	}

	private Integer getUniqueId() {
		UUID idOne = UUID.randomUUID();
		int uid = idOne.hashCode();
		return uid;
	}

	private static Set<FoodProducts> orderProducts;

	/******** Order ********/
	
	@RequestMapping("/cart/getById")
	public String getOrderById(@RequestParam("orderId") Integer orderId, Model model) {
		/*
		 * ResponseEntity<Order> order =
		 * restTemplate.getForEntity("http://annapurna-order/orders/" + orderId + " ",
		 * Order.class); System.out.println(order.getBody());
		 * model.addAttribute("message", "heyyyyyyyy !!!!"); model.addAttribute("Order",
		 * order.getBody());
		 */
		return annapurnaService.getOrderById(orderId, model);
	}
	
	

	@RequestMapping("/cart/submitAddress")
	public String placeOrder(@ModelAttribute Address address1, Model model) {
		/*
		 * address = address1; model.addAttribute("totalAmount", cart.getTotalAmount());
		 */
		return annapurnaService.placeOrder(address1, model);
		
		
	}
	
	@RequestMapping("/cart/placeOrder")
	public String getPlaceOrder(/* @RequestBody Cart cart, */Model model) {
		/*
		 * Set<FoodProducts> products = new HashSet<FoodProducts>(); products.add(new
		 * FoodProducts("Brinjal", 234, 12)); orderProducts = products;
		 */
		return annapurnaService.getPlaceOrder(model);
	}
	
	/******** eWallet ********/

	@RequestMapping("/cart/passMoneyForm")
	public String deduct(/* @RequestParam Integer profileId, */ @RequestParam Double amount, Model model) {
		/*
		 * restTemplate.put("http://annapurna-ewallet/ewallets/" + 1 +
		 * "/pay?currentBalance=" + amount, null); model.addAttribute("message",
		 * "money deducted and Order placed Successfully!"); String modeOfPayment =
		 * "E-Wallet"; // for now Double totalAmount = 100.0; // for now String
		 * restaurantName = "GrandMama's Cafe"; // for now Integer id = getUniqueId();
		 * Order order = new Order(id, modeOfPayment, "pending", cart.getProducts(),
		 * cart.getTotalAmount(), cart.getRestaurantName(), address, cart.getCartId());
		 * ResponseEntity<Order> order1 =
		 * restTemplate.postForEntity("http://annapurna-order/orders", order,
		 * Order.class); model.addAttribute("Order", order1.getBody());
		 * System.out.println(order1.getBody());
		 */
		return annapurnaService.deduct(amount, model);
	}

	@RequestMapping("/cart/AddMoneyLink")
	public String depositForm(@RequestParam Integer profileId, Model model) {
		model.addAttribute("profileId", profileId);
		return "addMoney";
	}

	@RequestMapping("/cart/AddMoneyForm")
	public String deposit(@RequestParam Integer profileId, @RequestParam Double amount, Model model) {
		System.out.println("profileId "+profileId);
		restTemplate.put("http://annapurna-ewallet/ewallets/" + profileId + "?currentBalance=" + amount, null);
		model.addAttribute("message", "money added Successfully!");
		return "addMoney";
	}

	@RequestMapping("/cart/currentEWalletBalance")
	public String getWalletBalance(@RequestParam Integer profileId, Model model) {
		ResponseEntity<Double> entity = restTemplate
				.getForEntity("http://annapurna-ewallet/ewallets/"+ profileId, Double.class);
		model.addAttribute("currentBalance", entity.getBody());
		model.addAttribute("profile", customUserDetailsService.getCurrentUser());
		return "EWalletBalance";
	}
	
	
	@RequestMapping("/cart/PassMoneyLink")
	public String deductAmount() {
		return "passMoney";
	}

	@RequestMapping("/cart/StatementForm")
	public String statementForm() {
		return "statements";
	}

	@RequestMapping("/cart/statement")
	public String statement(@RequestParam Integer profileId, Model model) {
		ResponseEntity<List> entity = restTemplate
				.getForEntity("http://annapurna-ewallet/ewallets/statements/" + profileId, List.class);
		List<Statement> statements= entity.getBody();
		System.out.println(statements);
		model.addAttribute("statements", statements);
		return "statements";
	}

}

package eCommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eCommerce.DAO.CartDAO;
import eCommerce.DAO.productDAO;
import eCommerce.model.CartItem;
import eCommerce.model.Product;

@Controller
public class CartController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	productDAO productDAO;
	
	@RequestMapping(value = {"/Cart", "/addToCart/Cart", "/updateCartItem/Cart", "deleteCartItem/Cart", "/editCategory/Cart", "/updateCategory/Cart", "deleteCategory/Cart", "deleteProduct/Cart", "editProduct/Cart", "fullProductDisplay/Cart"})
	public String showCart(Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		String username = (String) session.getAttribute("username");
		List<CartItem> cartItemList = cartDAO.listCartItem(username);
		
		myModel.addAttribute("cartItemList", cartItemList);
		myModel.addAttribute("grandTotal", cartDAO.getGrandTotal(cartItemList));
		
		return "Cart";
		
	}
	
	@RequestMapping(value= {"/addToCart/{productId}", "/updateCartItem/addToCart/{productId}", "deleteCartItem/addToCart/{productId}", "/editCategory/addToCart/{productId}", "/updateCategory/addToCart/{productId}", "deleteCategory/addToCart/{productId}", "deleteProduct/addToCart/{productId}", "editProduct/addToCart/{productId}", "fullProductDisplay/addToCart/{productId}"})
	public String addToCart(@PathVariable("productId") int productId, @RequestParam("quantity") int quantity, HttpSession session, Model myModel) {
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		Product product = productDAO.getProduct(productId);
		String userName = (String) session.getAttribute("username");
		
		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setQuantity(quantity);
		cartItem.setPrice(product.getProductPrice());
		cartItem.setPaymentStatus("NP");
		cartItem.setUserName(userName);
		
		cartDAO.addCartItem(cartItem);
		
		List<CartItem> cartItemList = cartDAO.listCartItem(userName);
		myModel.addAttribute("cartItemList", cartItemList);
		myModel.addAttribute("grandTotal", cartDAO.getGrandTotal(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping(value= {"updateCartItem/{cartItemId}", "/addToCart/updateCartItem/{cartItemId}", "deleteCartItem/updateCartItem/{cartItemId}", "/editCategory/updateCartItem/{cartItemId}", "/updateCategory/updateCartItem/{cartItemId}", "deleteCategory/updateCartItem/{cartItemId}", "deleteProduct/updateCartItem/{cartItemId}", "editProduct/updateCartItem/{cartItemId}", "fullProductDisplay/updateCartItem/{cartItemId}"})
	public String updateCartItem(@PathVariable("cartItemId") int cartItemId, Model myModel, HttpSession session, @RequestParam("quantity") int quantity) {
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		
		cartDAO.updateCartItem(cartItem);
		String username = (String) session.getAttribute("username");
		
		List<CartItem> cartItemList = cartDAO.listCartItem(username);
		
		myModel.addAttribute("cartItemList", cartItemList);
		myModel.addAttribute("grandTotal", cartDAO.getGrandTotal(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping(value = {"deleteCartItem/{cartItemId}", "/addToCart/deleteCartItem/{cartItemId}", "/updateCartItem/deleteCartItem/{cartItemId}", "/editCategory/deleteCartItem/{cartItemId}", "/updateCategory/deleteCartItem/{cartItemId}", "deleteCategory/deleteCartItem/{cartItemId}", "deleteProduct/deleteCartItem/{cartItemId}", "editProduct/deleteCartItem/{cartItemId}", "fullProductDisplay/deleteCartItem/{cartItemId}"})
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId, Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		String username = (String) session.getAttribute("username");
		
		List<CartItem> cartItemList = cartDAO.listCartItem(username);
		
		myModel.addAttribute("cartItemList", cartItemList);
		myModel.addAttribute("grandTotal", cartDAO.getGrandTotal(cartItemList));
		
		return "Cart";
	}
}

package eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import eCommerce.DAO.UserDAO;
import eCommerce.model.UserDetails;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = {"/registerNewCustomer", "/addToCart/registerNewCustomer", "/updateCartItem/registerNewCustomer", "/deleteCartItem/registerNewCustomer", "/editCategory/registerNewCustomer", "/updateCategory/registerNewCustomer", "/deleteCategory/registerNewCustomer", "/deleteProduct/registerNewCustomer", "/editProduct/registerNewCustomer", "/fullProductDisplay/registerNewCustomer"})
	public String registerUser(Model myModel, @ModelAttribute("newCustomer") UserDetails newCustomer) {
		
		userDAO.addCustomer(newCustomer);
		return "login";
		
	}
	
}

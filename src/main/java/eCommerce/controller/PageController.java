package eCommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eCommerce.DAO.categoryDAOInterface;
import eCommerce.DAO.productDAO;
import eCommerce.model.UserDetails;

@Controller
public class PageController {
	
	@Autowired
	categoryDAOInterface categoryDAO;
	
	@Autowired
	productDAO productDAO;
	
	@RequestMapping(value={"/login", "/addToCart/login", "/updateCartItem/login", "/deleteCartItem/login", "/editCategory/login", "/updateCategory/login", "/deleteCategory/login", "/deleteProduct/login", "/editProduct/login", "/fullProductDisplay/login"})
	public String showLogin(HttpSession session, Model myModel) {
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			session.setAttribute("username", session.getId());
		}else {
			
			myModel.addAttribute("productList", productDAO.listProducts());
			return "index";
			
		}
		
		return "login";
		
	}
	
	@RequestMapping(value={"/", "/addToCart/", "/updateCartItem/", "/deleteCartItem/", "/editCategory/", "/updateCategory/", "/deleteCategory/", "/deleteProduct/", "/editProduct/", "/fullProductDisplay/"})
	public String mainMenu(Model myModel, HttpSession session) {
		
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			session.setAttribute("username", session.getId());
		}
		
		myModel.addAttribute("productList", productDAO.listProducts());
		return "index";
		
	}
	
	@RequestMapping(value={"/register", "/addToCart/register", "/updateCartItem/register", "deleteCartItem/register", "/editCategory/register", "/updateCategory/register", "deleteCategory/register", "deleteProduct/register", "editProduct/register", "fullProductDisplay/register"})
	public String register(HttpSession session, Model myModel) {
		
		myModel.addAttribute("newCustomer", new UserDetails());
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			session.setAttribute("username", session.getId());
		}else {
			
			myModel.addAttribute("productList", productDAO.listProducts());
			return "index";
			
		}
		
		return "register";
		
	}
	
	@RequestMapping(value={"/about", "/addToCart/about", "/updateCartItem/about", "/deleteCartItem/about", "/editCategory/login", "/updateCategory/about", "deleteCategory/login", "/deleteProduct/about", "/editProduct/about", "/fullProductDisplay/about"})
	public String showAbout(HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			session.setAttribute("username", session.getId());
		}
		
		return "about";
		
	}
	
	@RequestMapping(value={"/contactUs", "/addToCart/contactUs", "/updateCartItem/contactUs", "/deleteCartItem/contactUs", "/editCategory/contactUs", "/updateCategory/contactUs", "deleteCategory/contactUs", "deleteProduct/contactUs", "editProduct/contactUs", "fullProductDisplay/contactUs"})
	public String showContactUs(HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			session.setAttribute("username", session.getId());
		}
		
		return "contactUs";
		
	}
	
	@RequestMapping(value={"/home", "/addToCart/home", "/updateCartItem/home", "/deleteCartItem/home", "/editCategory/home", "/updateCategory/home", "/deleteCategory/home", "/deleteProduct/home", "/editProduct/home", "/fullProductDisplay/home"})
	public String showHome(Model myModel, HttpSession session) {
		
		
		Object logCheck = session.getAttribute("loggedIn");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			session.setAttribute("username", session.getId());
		}
		
		myModel.addAttribute("productList", productDAO.listProducts());
		return "index";
		
	}
	
	@RequestMapping(value={"/category", "/addToCart/category", "/updateCartItem/category", "/deleteCartItem/category", "/editCategory/category", "/updateCategory/category", "/deleteCategory/category", "/deleteProduct/category", "/editProduct/category", "/fullProductDisplay/category"})
	public String showCategory(Model myModel, HttpSession session) {
		
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			
			session.setAttribute("loggedIn", false);
			session.setAttribute("username", session.getId());
			
			return "login";
		}
		
		if(isAdmin == null || isAdmin.equals(false)) {
			
			myModel.addAttribute("productList", productDAO.listProducts());
			return "index";
			
		}
		
		myModel.addAttribute("CategoryList", categoryDAO.listCategories());
		return "category";
		
	}
}

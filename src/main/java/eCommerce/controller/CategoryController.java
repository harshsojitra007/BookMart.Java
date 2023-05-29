package eCommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eCommerce.DAO.categoryDAOInterface;
import eCommerce.model.Category;

@Controller
public class CategoryController {
	
	@Autowired
	categoryDAOInterface categoryDAO;
	
	@RequestMapping(value = {"/AddCategory", "/addToCart/AddCategory", "/updateCartItem/AddCategory", "/deleteCartItem/AddCategory", "/editCategory/AddCategory", "/updateCategory/AddCategory", "/deleteCategory/AddCategory", "/deleteProduct/AddCategory", "/editProduct/AddCategory", "/fullProductDisplay/AddCategory"})
	public String addCategory(@RequestParam("categoryName") String __categoryName, @RequestParam("categoryDescription") String __categoryDesc, Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		categoryDAO.saveCategory(__categoryName, __categoryDesc);
		myModel.addAttribute("CategoryList", categoryDAO.listCategories());
		
		return "category";
	}
	
	@RequestMapping(value = {"/editCategory/{categoryId}", "/addToCart/editCategory/{categoryId}", "/updateCartItem/editCategory/{categoryId}", "/deleteCartItem/editCategory/{categoryId}", "/updateCategory/editCategory/{categoryId}", "/deleteCategory/editCategory/{categoryId}", "/deleteProduct/editCategory/{categoryId}", "/editProduct/editCategory/{categoryId}", "/fullProductDisplay/editCategory/{categoryId}"})
	public String editCategory(Model myModel, @PathVariable("categoryId") int categoryId, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		Category myCategory = categoryDAO.getCategory(categoryId);
		myModel.addAttribute("currCategory", myCategory);
		
		return "updateCategory";
	}
	
	@RequestMapping(value = {"updateCategory/{categoryId}", "/addToCart/updateCategory/{categoryId}", "/updateCartItem/updateCategory/{categoryId}", "/deleteCartItem/updateCategory/{categoryId}", "/editCategory/updateCategory/{categoryId}", "/deleteCategory/updateCategory/{categoryId}", "/deleteProduct/updateCategory/{categoryId}", "/editProduct/updateCategory/{categoryId}", "/fullProductDisplay/updateCategory/{categoryId}"})
	public String updateCategory(Model myModel, @PathVariable("categoryId") int categoryId, @RequestParam("categoryName") String _newCatName, @RequestParam("categoryDescription") String _newCatDesc, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		categoryDAO.updateCategory(categoryId, _newCatName, _newCatDesc);
		myModel.addAttribute("CategoryList", categoryDAO.listCategories());
		
		return "category";
	}
	
	@RequestMapping(value = {"deleteCategory/{categoryId}", "/addToCart/deleteCategory/{categoryId}", "/updateCartItem/deleteCategory/{categoryId}", "/deleteCartItem/deleteCategory/{categoryId}", "/editCategory/deleteCategory/{categoryId}", "/updateCategory/deleteCategory/{categoryId}", "/deleteCategory/deleteCategory/{categoryId}", "/deleteProduct/deleteCategory/{categoryId}", "/editProduct/deleteCategory/{categoryId}", "/fullProductDisplay/deleteCategory/{categoryId}"})
	public String deleteCategory(@PathVariable("categoryId") int categoryId, Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		categoryDAO.deleteCategory(categoryId);
		myModel.addAttribute("CategoryList", categoryDAO.listCategories());
		
		return "category";
	}
}

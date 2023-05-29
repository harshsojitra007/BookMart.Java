package eCommerce.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import eCommerce.DAO.categoryDAOInterface;
import eCommerce.DAO.productDAO;
import eCommerce.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	categoryDAOInterface categoryDAO;
	
	@Autowired
	productDAO productDAO;
	
	@RequestMapping(value = {"/product", "/addToCart/product", "/updateCartItem/product", "/deleteCartItem/product", "/editCategory/product", "/updateCategory/product", "/deleteCategory/product", "/deleteProduct/product", "/editProduct/product", "/fullProductDisplay/product"})
	public String showProducts(Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		Product newInsertingProduct = new Product();
		myModel.addAttribute("newInsertingProduct", newInsertingProduct);
		myModel.addAttribute("categoryList", categoryDAO.listCategories());
		
		List<Product> productList = productDAO.listProducts();
		myModel.addAttribute("productList", productList);
		
		return "Product";
	}
	
	@RequestMapping(value = {"/InsertProduct", "/addToCart/InsertProduct", "/updateCartItem/InsertProduct", "/deleteCartItem/InsertProduct", "/editCategory/InsertProduct", "/updateCategory/InsertProduct", "/deleteCategory/InsertProduct", "/deleteProduct/InsertProduct", "/editProduct/InsertProduct", "/fullProductDisplay/InsertProduct"})
	public String insertProduct(@ModelAttribute("newInsertingProduct") Product newProduct, @RequestParam("productImage") MultipartFile imageFile, Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		if(newProduct.getProductId() != 0) {
			productDAO.updateProduct(newProduct);
		}else {
			productDAO.addProduct(newProduct);
		}
		String imagePath = "E:\\Semester-4\\Java_Project\\WebApp\\final\\src\\main\\webapp\\WEB-INF\\Images\\";
		imagePath += String.valueOf(newProduct.getProductId() + ".jpg");
		
		File image = new File(imagePath);
		if(!imageFile.isEmpty()) {
			
			try {
				
				byte[] buffer = imageFile.getBytes();
				FileOutputStream outputStream = new FileOutputStream(image);
				BufferedOutputStream bufferedStream = new BufferedOutputStream(outputStream);
				bufferedStream.write(buffer);
				bufferedStream.close();
				
			}catch(Exception e) {
				
			}
		}
		List<Product> productList = productDAO.listProducts();
		myModel.addAttribute("productList", productList);
		myModel.addAttribute("categoryList", categoryDAO.listCategories());
		myModel.addAttribute("newInsertingProduct", new Product());
		
		return "Product";
	}
	
	@RequestMapping(value = {"/deleteProduct/{productId}", "/addToCart/deleteProduct/{productId}", "/updateCartItem/deleteProduct/{productId}", "/deleteCartItem/deleteProduct/{productId}", "/editCategory/deleteProduct/{productId}", "/updateCategory/deleteProduct/{productId}", "/deleteCategory/deleteProduct/{productId}", "/editProduct/deleteProduct/{productId}", "/fullProductDisplay/deleteProduct/{productId}"})
	public String updateProduct(@PathVariable("productId") int productId, Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		String imagePath = "E:\\Semester-4\\Java_Project\\WebApp\\final\\src\\main\\webapp\\WEB-INF\\Images\\";
		imagePath += String.valueOf(productId + ".jpg");
		
		File image = new File(imagePath);
		image.delete();
		
		Product product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> productList = productDAO.listProducts();
		myModel.addAttribute("newInsertingProduct", new Product());
		myModel.addAttribute("productList", productList);
		myModel.addAttribute("categoryList", categoryDAO.listCategories());
		
		return "Product";
		
	}
	
	@RequestMapping(value = {"/editProduct/{productId}", "/addToCart/editProduct/{productId}", "/updateCartItem/editProduct/{productId}", "/deleteCartItem/editProduct/{productId}", "/editCategory/editProduct/{productId}", "/updateCategory/editProduct/{productId}", "/deleteCategory/editProduct/{productId}", "/deleteProduct/editProduct/{productId}", "/fullProductDisplay/editProduct/{productId}"})
	public String editProduct(@PathVariable("productId") int productId, Model myModel, HttpSession session) {
		
		Object logCheck = session.getAttribute("loggedIn");
		Object isAdmin = session.getAttribute("isAdmin");
		
		if(logCheck == null || logCheck.equals(false)) {
			session.setAttribute("loggedIn", false);
			return "login";
		}
		
		if(isAdmin.equals(false)) {
			return "index";
		}
		
		Product product = productDAO.getProduct(productId);
		myModel.addAttribute("newInsertingProduct", product);
		myModel.addAttribute("productList", productDAO.listProducts());
		myModel.addAttribute("categoryList", categoryDAO.listCategories());
		
		return "Product";
	}
	
	@RequestMapping(value = {"fullProductDisplay/{productId}", "/addToCart/fullProductDisplay/{productId}", "/updateCartItem/fullProductDisplay/{productId}", "/deleteCartItem/fullProductDisplay/{productId}", "/editCategory/fullProductDisplay/{productId}", "/updateCategory/fullProductDisplay/{productId}", "/deleteCategory/fullProductDisplay/{productId}", "/deleteProduct/fullProductDisplay/{productId}", "/editProduct/fullProductDisplay/{productId}"})
	public String showProductDetails(@PathVariable("productId") int productId, Model myModel) {
		
		Product currProduct = productDAO.getProduct(productId);
		myModel.addAttribute("product", currProduct);
		
		return "fullProductDisplay";
	}
	
}

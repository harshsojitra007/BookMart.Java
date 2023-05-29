package eCommerce.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import eCommerce.model.Product;

@Service
public interface productDAO {
	
	public List<Product> listProducts();
	public void addProduct(Product newProduct);
	public Product getProduct(int _productId);
	public void deleteProduct(Product product);
	public void updateProduct(Product _newProduct);
	
}

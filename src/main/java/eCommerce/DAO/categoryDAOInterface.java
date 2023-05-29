package eCommerce.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import eCommerce.model.Category;

@Service
public interface categoryDAOInterface {
	
	public void saveCategory(String _categoryName, String _categoryDesc);
	public List<Category> listCategories();
	public Category getCategory(int _categoryId);
	public void updateCategory(int _catId, String _newCatName, String _newCatDesc);
	public void deleteCategory(int _categoryId);
	
}

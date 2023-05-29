package eCommerce.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import eCommerce.model.Category;

@Service
public class categoryDAOImpl implements categoryDAOInterface{
	
	public void saveCategory(String _categoryName, String _categoryDesc) {
		
		Category newCategory = new Category();
		newCategory.setCategoryName(_categoryName);
		newCategory.setCategoryDesc(_categoryDesc);
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Category.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.save(newCategory);
		
		currTransaction.commit();
	}
	
	public List<Category> listCategories(){
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Category.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("from Category");
		List<Category> myList = query.getResultList();
		
		currTransaction.commit();
		
		return myList;
	}
	
	public Category getCategory(int _categoryId) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Category.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("from Category where id=" + _categoryId);
		Object myCategory = query.getSingleResult();
		
		currTransaction.commit();
		
		return (Category) myCategory;
	}
	
	public void updateCategory(int _catId, String _newCatName, String _newCatDesc) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Category.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("UPDATE Category as c set c.categoryName = :newCatName where c.categoryId = :CatId");
		
		query.setParameter("newCatName", _newCatName);
		query.setParameter("CatId", _catId);
		
		query.executeUpdate();
		
		query = currSession.createQuery("UPDATE Category as c set c.categoryDesc = :newCatDesc where c.categoryId = :CatId");
		
		query.setParameter("newCatDesc", _newCatDesc);
		query.setParameter("CatId", _catId);
		
		query.executeUpdate();
		
		currTransaction.commit();
	}
	
	public void deleteCategory(int _categoryId) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Category.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("DELETE FROM Category c where c.categoryId = :CatId");
		query.setParameter("CatId", _categoryId);
		
		query.executeUpdate();
		
		currTransaction.commit();
	}
}
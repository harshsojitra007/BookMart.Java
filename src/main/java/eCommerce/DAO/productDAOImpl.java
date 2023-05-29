package eCommerce.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import eCommerce.model.Product;

@Service
public class productDAOImpl implements productDAO{
	
	public List<Product> listProducts(){
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("from Product");
		List<Product> myList = query.getResultList();
		
		currTransaction.commit();
		
		return myList;
	}
	
	public void addProduct(Product newProduct) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.save(newProduct);
		
		currTransaction.commit();
		
	}
	
	public Product getProduct(int _productId) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("from Product where productId = :myId");
		query.setParameter("myId", _productId);
		
		Product myProduct = (Product) query.getSingleResult();
		
		currTransaction.commit();
		return myProduct;
	}
	
	public void updateProduct(Product _product) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.update(_product);
		
		currTransaction.commit();
	}
	
	public void deleteProduct(Product product) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.remove(product);
		currTransaction.commit();
	}
}

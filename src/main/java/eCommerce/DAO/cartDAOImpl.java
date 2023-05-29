package eCommerce.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eCommerce.model.CartItem;
import eCommerce.model.Category;

@Repository("cartDAO")
@Transactional
public class cartDAOImpl implements CartDAO{

	public boolean addCartItem(CartItem cartItem) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(CartItem.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.save(cartItem);
		
		currTransaction.commit();
		return true;
		
	}

	public boolean deleteCartItem(CartItem cartItem) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(CartItem.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.remove(cartItem);
		
		currTransaction.commit();
		return true;
	}

	public boolean updateCartItem(CartItem cartItem) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(CartItem.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.update(cartItem);
		
		currTransaction.commit();
		return false;
	}

	public CartItem getCartItem(int cartItemId) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(CartItem.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("from CartItem where cartItemId=" + cartItemId);
		Object cartItem = query.getSingleResult();
		
		currTransaction.commit();
		return (CartItem) cartItem;
	}

	public List<CartItem> listCartItem(String userName) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(CartItem.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("from CartItem where userName = :username");
		query.setParameter("username", userName);
		
		List<CartItem> myList = query.getResultList();
		
		currTransaction.commit();
		return myList;
	}
	
	public long getGrandTotal(List<CartItem> cartItemList) {
		
		long grandTotal = 0;
		
		for(CartItem item:cartItemList) {
			grandTotal += (item.getPrice() * item.getQuantity());
		}
		
		return grandTotal;
	}
	
}

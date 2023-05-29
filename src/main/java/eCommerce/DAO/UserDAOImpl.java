package eCommerce.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import eCommerce.model.UserDetails;

@Service
public class UserDAOImpl implements UserDAO{

	public UserDetails getCustomer(int customerId) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		Query query = currSession.createQuery("from UserDetails where customerId=" + customerId);
		Object customer = query.getSingleResult();
		
		currTransaction.commit();
		return (UserDetails) customer;
		
	}

	public void addCustomer(UserDetails newCustomer) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.save(newCustomer);
		currTransaction.commit();
		
	}

	public void deleteCustomer(UserDetails customer) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.remove(customer);
		currTransaction.commit();
		
	}

	public void updateCustomer(UserDetails customer) {
		
		Configuration myConfig = new Configuration().configure().addAnnotatedClass(UserDetails.class);
		SessionFactory myFactory = myConfig.buildSessionFactory();
		
		Session currSession = myFactory.openSession();
		Transaction currTransaction = currSession.beginTransaction();
		
		currSession.update(customer);
		currTransaction.commit();
		
	}

}

package eCommerce.DAO;

import org.springframework.stereotype.Service;

import eCommerce.model.UserDetails;

@Service
public interface UserDAO {
	
	public UserDetails getCustomer(int customerId);
	public void addCustomer(UserDetails newCustomer);
	public void deleteCustomer(UserDetails customer);
	public void updateCustomer(UserDetails customer);
	
}

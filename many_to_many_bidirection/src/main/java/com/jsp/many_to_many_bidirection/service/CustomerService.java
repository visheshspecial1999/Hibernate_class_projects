package com.jsp.many_to_many_bidirection.service;

import java.util.List;

import com.jsp.many_to_many_bidirection.dao.CustomerDao;
import com.jsp.many_to_many_bidirection.dto.Customer;

public class CustomerService {
	
	CustomerDao dao=new CustomerDao();
	
	// insertCustomer method
		public void insertCustomer(Customer customer) {
			dao.insertCustomer(customer);
		}
		
		// searchCustomer method
		public Customer searchCustomer(int customerId) {
			return dao.searchCustomer(customerId);
		}
		
		// updateCustomer method
		public void updateCustomer(Customer customer) {
		Customer customer2	=dao.searchCustomer(customer.getCustomerId());
		if(customer2!=null) {
			dao.updateCustomer(customer);
		}
		else {
			System.out.println("customerId not present in database");
		}
		}
		
		// deleteCustomer method
		public void deleteCustomer(int customerId) {
			Customer customer2	=dao.searchCustomer(customerId);
			if(customer2!=null) {
				dao.deleteCustomer(customerId);
			}
			else {
				System.out.println("customerId not present or already has been deleted");
			}
		}
		
		// displayCustomer method
		public List<Customer> displayCustomer() {
			return dao.displayCustomer();
		}
}
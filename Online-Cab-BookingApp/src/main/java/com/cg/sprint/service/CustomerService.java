package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.Customer;

public interface CustomerService {
	Customer insertCustomer(Customer cust);
	Customer updateCustomer(Customer cust);
	void deleteCustomer(Long customerId);
	List<Customer> viewCustomers();
	Customer viewCustomer(Long customerId);
	Boolean validateCustomer(Long customerId,String password);
}

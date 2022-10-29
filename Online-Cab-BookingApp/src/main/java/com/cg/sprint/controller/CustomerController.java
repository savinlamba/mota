package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.Customer;
import com.cg.sprint.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	//inserting the customer
	@PostMapping("/")
	public ResponseEntity<Customer> insertCustomer(@RequestBody @Valid Customer customer){
		Customer cus = customerService.insertCustomer(customer);
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(cus, HttpStatus.CREATED);
		return response;
	}
	
	//update the customer
	@PutMapping("/")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer cus = customerService.updateCustomer(customer);
		ResponseEntity<Customer> reponse = new ResponseEntity<Customer>(cus, HttpStatus.OK);
		return reponse;
	}
	
	//delete customer using customer id
	@DeleteMapping("/{customer_id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customer_id") Long customerId){
		customerService.deleteCustomer(customerId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
	}
	
	//get all customers
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getallCustomers() {
		List<Customer> customers = customerService.viewCustomers();
		ResponseEntity<List<Customer>> response = new ResponseEntity<>(customers, HttpStatus.OK);
		return response;
	}
	
	//get customer using customer id
	@GetMapping("/{customer_id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customer_id") Long customerId) {
		Customer customer = customerService.viewCustomer(customerId);
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer, HttpStatus.OK);
		return response;
	}
}

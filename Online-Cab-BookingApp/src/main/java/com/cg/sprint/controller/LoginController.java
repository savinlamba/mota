package com.cg.sprint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.service.AdminService;
import com.cg.sprint.service.CustomerService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	CustomerService customerService;
	@Autowired
	AdminService admin1;

	@PostMapping("/customer")
	public ResponseEntity<String> loginCustomer(@RequestBody Customer cust1) {
		if (customerService.validateCustomer(cust1.getCustomerId(), cust1.getPassword())) {
			ResponseEntity<String> response = new ResponseEntity<String>("Login Sucess", HttpStatus.ACCEPTED);
			return response;
		} else {
			ResponseEntity<String> response = new ResponseEntity<String>("Invalid Credentials",
					HttpStatus.NOT_ACCEPTABLE);
			return response;
		}

	}

	@PostMapping("/admin")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) {
		String message=admin1.validateAdmin(admin.getAdminId(), admin.getPassword());
		ResponseEntity<String> response = new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
		return response;

	}
}

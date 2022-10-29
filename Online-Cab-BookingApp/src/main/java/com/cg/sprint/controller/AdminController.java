package com.cg.sprint.controller;

import java.time.LocalDateTime;
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

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.service.AdminService;
import com.cg.sprint.service.TripBookingService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	TripBookingService tripBookingService;

	// inserting the admin
	@PostMapping("/")
	public ResponseEntity<Admin> insertAdmin(@RequestBody @Valid Admin adm) {
		Admin ad = adminService.insertAdmin(adm);
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(ad, HttpStatus.CREATED);
		return response;
	}

	// update the admin
	@PutMapping("/")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		Admin adm = adminService.updateAdmin(admin);
		ResponseEntity<Admin> reponse = new ResponseEntity<Admin>(adm, HttpStatus.OK);
		return reponse;
	}

	// delete admin using admin id
	@DeleteMapping("/{admin_id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("admin_id") Long adminId) {
		adminService.deleteAdmin(adminId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
	}

	// get all trips method
	@GetMapping("/trips")
	public ResponseEntity<List<TripBooking>> getallTrips() {
		List<TripBooking> trips = adminService.getAllTrips();
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<>(trips, HttpStatus.OK);
		return response;
	}

	// get all trips method
	@GetMapping("/trips/customers/{customer_id}")
	public ResponseEntity<List<TripBooking>> getTripsCustomerwise(@PathVariable("customer_id") Long customerId) {
		List<TripBooking> trips = adminService.getTripsCustomerwise(customerId);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<>(trips, HttpStatus.OK);
		return response;
	}

	// get trips using cab id method
	@GetMapping("/trips/cab/{cab_id}")
	public ResponseEntity<List<TripBooking>> getTripsCabwise(@PathVariable("cab_id") Long cabId) throws CabNotFoundException {
		List<TripBooking> trips = adminService.getTripsCabwise(cabId);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<>(trips, HttpStatus.OK);
		return response;
	}
	
	//get trips for a date
	@GetMapping("/trips/{date}")
	public ResponseEntity<List<TripBooking>> getTripsDatewise(@PathVariable("date") String date) {
		LocalDateTime dt=LocalDateTime.parse(date);
		List<TripBooking> trips = adminService.getTripsDatewise(dt);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<>(trips, HttpStatus.OK);
		return response;
	}
	
	//get all trips using customer id, from date and to date
	@GetMapping("/trips/customers/{customer_id}/{from_date}/{to_date}")
	public ResponseEntity<List<TripBooking>> getAllTripsForDays(@PathVariable("customer_id") Long customerId,@PathVariable("from_date") LocalDateTime fromDate,@PathVariable("to_date") LocalDateTime toDate) {
		List<TripBooking> trips = adminService.getAllTripsForDays(customerId, fromDate, toDate);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<>(trips, HttpStatus.OK);
		return response;
	}
}

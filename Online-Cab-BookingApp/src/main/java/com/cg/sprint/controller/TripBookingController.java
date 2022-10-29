package com.cg.sprint.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.repository.AdminRepository;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.CabService;
import com.cg.sprint.service.CustomerService;
import com.cg.sprint.service.TripBookingService;

@RestController
@RequestMapping("/api/tripbookings")
public class TripBookingController {

	@Autowired
	TripBookingService tripBookingService;
	@Autowired
	TripBookingRepository tripBookingRepository;
	@Autowired
	CabRepository cabRepository;
	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/{cab_id}/{customer_id}")
	public ResponseEntity<TripBooking> insertTripBooking(@RequestBody @Valid TripBooking trb,
			@PathVariable("cab_id") Long cabId, @PathVariable("customer_id") Long customerId) {

		TripBooking tb = tripBookingService.insertTripBooking(trb, cabId, customerId);
		ResponseEntity<TripBooking> response = new ResponseEntity<TripBooking>(tb, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/{cab_id}/{customer_id}")
	public ResponseEntity<TripBooking> updateTripBooking(@RequestBody TripBooking tripBooking,
			@PathVariable("cab_id") Long cabId, @PathVariable("customer_id") Long customerId) {
		Optional<Cab> cab = cabRepository.findById(cabId);
		Optional<Customer> customer = customerRepository.findById(customerId);
		TripBooking tripBooking1 = tripBookingService.updateTripBooking(tripBooking);
		ResponseEntity<TripBooking> reponse = new ResponseEntity<TripBooking>(tripBooking1, HttpStatus.OK);
		return reponse;
	}

	// delete admin using admin id
	@DeleteMapping("/{tripBooking_id}")
	public ResponseEntity<String> deleteTripBooking(@PathVariable("tripBooking_id") Long tripBookingId) {
		tripBookingService.deleteTripBooking(tripBookingId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
	}

	@GetMapping("/{customer_id}")
	public ResponseEntity<List<TripBooking>> getTripBookingCustomerwise(@PathVariable("customer_id") Long customerId) {
		List<TripBooking> trips = tripBookingService.viewAllTripCustomer(customerId);
		ResponseEntity<List<TripBooking>> response = new ResponseEntity<>(trips, HttpStatus.OK);
		return response;
	}

	@GetMapping("/bill/{customer_id}")
	public ResponseEntity<TripBooking> getTripBillCustomerwise(@PathVariable("customer_id") Long customerId) {
		TripBooking trips = tripBookingService.calculateBill(customerId);
		ResponseEntity<TripBooking> response = new ResponseEntity<>(trips, HttpStatus.OK);
		return response;
	}

}

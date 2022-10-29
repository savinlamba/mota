package com.cg.sprint.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Customer extends User{
	@Id
	@Column(name="customer_id")
	private Long customerId;
	
//	@OneToMany(mappedBy = "customer")
//	@JsonManagedReference(value="customer")
//	private List<TripBooking> tripBooking;
//
//	public List<TripBooking> getTripBooking() {
//		return tripBooking;
//	}
//
//	public void setTripBooking(List<TripBooking> tripBooking) {
//		this.tripBooking = tripBooking;
//	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}

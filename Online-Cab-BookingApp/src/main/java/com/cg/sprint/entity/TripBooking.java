package com.cg.sprint.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.*;

@Entity
public class TripBooking {

	@Id
	@Column(name ="trip_booking_id")
	private Long tripBookingId;
	
	@ManyToOne(targetEntity = Customer.class)
//	@JsonBackReference(value="customer")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerId")
	@JsonIdentityReference(alwaysAsId = true)
	private Customer customer;
	
	@ManyToOne(targetEntity = Cab.class)
//	@JsonBackReference(value="cab")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cabId")
	@JsonIdentityReference(alwaysAsId = true)
	private Cab cab;
	
	@NotNull
	private String fromLocation;
	@NotNull
	private String toLocation;
	@NotNull
	private LocalDateTime fromDateTime;
	@NotNull
	private LocalDateTime toDateTime;
	private Boolean status;
	@NotBlank
	private Float distanceInKm;
	
	private Float bill;

	public Long getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(Long tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public Boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(Float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public Float getBill() {
		return bill;
	}

	public void setBill(Float bill) {
		this.bill = bill;
	}

}

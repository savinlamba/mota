package com.cg.sprint.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cab {

	@Id
	private Long cabId;
//	@NotBlank(message="car type must not be empty")
	private String carType;
//	@Positive(message="Rate per Km must be positive")
	private Float perKmRate;
	@OneToOne
	@JsonManagedReference
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "driverId")
	@JsonIdentityReference(alwaysAsId = true)
	private Driver driver;
	@OneToMany(mappedBy = "cab")
	@JsonManagedReference(value="cab")
	private List<TripBooking> tripBooking;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}
	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}
	public Long getCabId() {
		return cabId;
	}

	public void setCabId(Long cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public Float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(Float perKmRate) {
		this.perKmRate = perKmRate;
	}

}

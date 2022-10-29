package com.cg.sprint.service;

import java.util.List;

import com.cg.sprint.entity.TripBooking;

public interface TripBookingService {
 
	TripBooking insertTripBooking(TripBooking tripBooking, Long cabId, Long customerId);
	TripBooking updateTripBooking(TripBooking tripBooking, Long cabId, Long customerId);
	TripBooking deleteTripBooking(Long tripBookingId);
	List<TripBooking> viewAllTripCustomer(Long customerId);
	TripBooking calculateBill(Long customerId);
}

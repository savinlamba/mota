package com.cg.sprint.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.TripBookingService;

@Service
public class TripBookingServiceImpl implements TripBookingService {

	@Autowired
	TripBookingRepository tripBookingRepository;
	@Autowired
	CabRepository cabRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking,Long cabId,Long customerId) {
		Cab cab = cabRepository.findById(cabId).get();
		Customer customer = customerRepository.findById(customerId).get();
		tripBooking.setCustomer(customer);
		tripBooking.setCab(cab);
		tripBookingRepository.save(tripBooking);
		return tripBooking;
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking,Long cabId,Long customerId) {
		
		Optional<TripBooking> trpbkOpt =  tripBookingRepository.findById(tripBooking.getTripBookingId());
		TripBooking tripBooking1=null;
		tripBooking1=trpbkOpt.get();
		Cab cab = cabRepository.findById(cabId).get();
		Customer customer = customerRepository.findById(customerId).get();
		tripBooking1.setCustomer(customer);
		tripBooking1.setCab(cab);
		tripBooking1.setTripBookingId(tripBooking.getTripBookingId());
		tripBooking1.setFromLocation(tripBooking.getFromLocation());
		tripBooking1.setToLocation(tripBooking.getToLocation());
		tripBooking1.setFromDateTime(tripBooking.getFromDateTime());
		tripBooking1.setToDateTime(tripBooking.getToDateTime());
		tripBooking1.setStatus(tripBooking.isStatus());
		tripBooking1.setDistanceInKm(tripBooking.getDistanceInKm());
		tripBooking1.setBill(tripBooking.getBill());
		tripBookingRepository.save(tripBooking1);
		return tripBooking1;
	}

	@Override
	public TripBooking deleteTripBooking(Long tripBookingId) {
		tripBookingRepository.deleteById(tripBookingId);
		return null;
	}

	@Override
	public List<TripBooking> viewAllTripCustomer(Long customerId) {
		
		return tripBookingRepository.findAll().stream().filter(t->t.getCustomer().getCustomerId().equals(customerId)).toList();                       
	}

	@Override
	public TripBooking calculateBill(Long customerId) {
		List<TripBooking> trip1 =tripBookingRepository.findAll();
		TripBooking trip=new TripBooking();
		for(TripBooking tripop:trip1)
		{
			if(tripop.getCustomer().getCustomerId().equals(customerId))
			{
				trip=tripop;
				break;
			}
		}
		trip.setBill((trip.getDistanceInKm())*(trip.getCab().getPerKmRate()));
		return trip;
	}

}

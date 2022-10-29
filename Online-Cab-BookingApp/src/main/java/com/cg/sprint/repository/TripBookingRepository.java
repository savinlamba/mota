package com.cg.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.sprint.entity.TripBooking;

public interface TripBookingRepository extends JpaRepository<TripBooking, Long>{
//	List<TripBooking> findTripByCustomerCustomerId(Long customerId) ;
//	List<TripBooking> findTripByCabCabId(Long cabId);
}


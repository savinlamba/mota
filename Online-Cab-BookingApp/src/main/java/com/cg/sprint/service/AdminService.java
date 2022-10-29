package com.cg.sprint.service;

import java.time.LocalDateTime;
import java.util.List;


import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.CabNotFoundException;

public interface AdminService {
	Admin insertAdmin(Admin adm);
	Admin updateAdmin(Admin adm);
	void deleteAdmin(Long adminId);
  
	List<TripBooking> getAllTrips();
	List<TripBooking> getTripsCabwise(Long cabId)throws CabNotFoundException;
	List<TripBooking> getTripsCustomerwise(Long customerId);
	List<TripBooking> getTripsDatewise(LocalDateTime date);
	List<TripBooking> getAllTripsForDays(Long customerId, LocalDateTime fromDate,LocalDateTime toDate);
	String validateAdmin(Long adminId, String password);
}

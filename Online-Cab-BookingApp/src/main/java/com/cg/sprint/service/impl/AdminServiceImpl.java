package com.cg.sprint.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Admin;
import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.TripBooking;
import com.cg.sprint.exception.AdminNotFoundException;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;
import com.cg.sprint.repository.AdminRepository;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.repository.CustomerRepository;
import com.cg.sprint.repository.TripBookingRepository;
import com.cg.sprint.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	CabRepository cabRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TripBookingRepository tripBookingRepository;

	// insert admin method
	@Override
	public Admin insertAdmin(Admin adm) {
		adminRepository.save(adm);
		return adm;
	}

	// update admin method
	@Override
	public Admin updateAdmin(Admin adm) throws AdminNotFoundException {
		Admin admOpt = adminRepository.findByAdminId(adm.getAdminId());
		if (admOpt!=null) {
			admOpt.setAdminId(adm.getAdminId());
			admOpt.setUsername(adm.getUsername());
			admOpt.setPassword(adm.getPassword());
			admOpt.setAddress(adm.getAddress());
			admOpt.setMobileNumber(adm.getMobileNumber());
			admOpt.setEmail(adm.getEmail());
			adminRepository.save(admOpt);
			return admOpt;
		} else {
			throw new AdminNotFoundException("No such admin found");
		}
	}

	// delete admin method
	@Override
	public void deleteAdmin(Long adminId) throws AdminNotFoundException {
		Optional<Admin> admOpt = adminRepository.findById(adminId);
		if (admOpt.isPresent()) {
			adminRepository.deleteById(adminId);
		} else {
			throw new AdminNotFoundException("No such admin found");
		}
	}

	// get all trips method
	@Override
	public List<TripBooking> getAllTrips() {
		return tripBookingRepository.findAll();
	}

	// get trips using cab id
	@Override
	public List<TripBooking> getTripsCabwise(Long cabId) throws CabNotFoundException {
//		Optional<Cab> cabOpt = cabRepository.findById(cabId);
//		if (cabOpt.isPresent()) {
//			return cabRepository.findTripByTripBooking(cabId);
//		} else {
//			throw new CabNotFoundException("No such cab found");
//		}
		return null;
	}

	// get trips using customer id
	@Override
	public List<TripBooking> getTripsCustomerwise(Long customerId) throws CustomerNotFoundException {
//		Optional<Customer> custOpt = customerRepository.findById(customerId);
//		if (custOpt.isPresent()) {
//			return tripBookingRepository.findTripByCustomerCustomerId(customerId);
//		} else {
//			throw new CustomerNotFoundException("No such customer found");
//		}
		return null;
	}

	// get trips using date
	@Override
	public List<TripBooking> getTripsDatewise(LocalDateTime date) {
		return tripBookingRepository.findAll().stream()
				.filter(t -> t.getFromDateTime().getDayOfYear() == date.getDayOfYear()).toList();
	}

	// get trips using customer id and between date
	@Override
	public List<TripBooking> getAllTripsForDays(Long customerId, LocalDateTime fromDate, LocalDateTime toDate) {
		return tripBookingRepository.findAll().stream().filter(t -> t.getCustomer().getCustomerId().equals(customerId)
				&& (t.getFromDateTime().isAfter(fromDate) && t.getFromDateTime().isBefore(toDate))).toList();
	}

	@Override
	public String validateAdmin(Long adminid, String password) {
		Admin adminid1 = adminRepository.findUserByadminId(adminid);
			if (adminid1!=null&&adminid1.getPassword().equals(password)) {

				return "Login Successful";

			} else {
				throw new AdminNotFoundException("Either admin id or password is incorrect");
			}

	}

}

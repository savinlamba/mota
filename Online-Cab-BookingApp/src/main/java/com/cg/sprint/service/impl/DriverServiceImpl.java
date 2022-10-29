package com.cg.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Driver;
import com.cg.sprint.repository.DriverRepository;
import com.cg.sprint.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	DriverRepository driverRepository;
	
	
	//insert driver method
	@Override
	public Driver insertDriver(Driver driver) {
		driverRepository.save(driver);
		return driver;
	}

	//update driver method
	@Override
	public Driver updateDriver(Driver driver) {
		Optional<Driver> driverOpt = driverRepository.findById(driver.getDriverId());
		Driver driver1 = null;
		driver1 = driverOpt.get();
		driver1.setDriverId(driver.getDriverId());
		driver1.setLicenceNO(driver.getLicenceNO());
//		driver1.setCab(driver.getCab());
		driver1.setRating(driver.getRating());
		driverRepository.save(driver1);

		return driver1;
	}

	//delete driver using driver id method
	@Override
	public void deleteDriver(Long driverId) {
		driverRepository.deleteById(driverId);
	}

	//view best drivers method
	@Override
	public List<Driver> viewDrivers() {
		return driverRepository.findAll();	
	}

	//view driver using driver id method
	@Override
	public Driver viewDriver(Long driverId) {
		Optional<Driver> driver = driverRepository.findById(driverId);
		return driver.get();
	}

}

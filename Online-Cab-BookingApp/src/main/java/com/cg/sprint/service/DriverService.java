package com.cg.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Driver;


@Service
public interface DriverService {

	Driver insertDriver(Driver driver);
	Driver updateDriver(Driver driver);
	void deleteDriver(Long driverId);
	List<Driver> viewDrivers();
	Driver viewDriver(Long driverId);
}

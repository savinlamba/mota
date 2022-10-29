package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.Driver;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.InvalidCarTypeException;
import com.cg.sprint.repository.DriverRepository;
import com.cg.sprint.service.CabService;

@RestController
@RequestMapping("api/cabs")
public class CabController {

	@Autowired
	CabService cabService;
	@Autowired
	DriverRepository driverRepository;
	
	
	@PostMapping("/{driver_id}")
	public ResponseEntity<Cab> insertCab(@RequestBody @Valid Cab cab,@PathVariable("driver_id") Long driverId){
		Driver driver=driverRepository.findById(driverId).get();
		Cab cab1=cab;
		cab1.setDriver(driver);
		cabService.insertCab(cab1);
		ResponseEntity<Cab> response = new ResponseEntity<Cab>(cab1, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/")
	public ResponseEntity<Cab> updateCab(@RequestBody Cab cab){
		Cab cab1 = cabService.updateCab(cab);
		ResponseEntity<Cab> reponse = new ResponseEntity<Cab>(cab1, HttpStatus.OK);
		return reponse;
	}
	
	@DeleteMapping("/{cabId}")
	public ResponseEntity<String> deleteCab(@PathVariable("cabId") Long cabId) throws CabNotFoundException{
		cabService.deleteCab(cabId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
	}
	
	@GetMapping("/{cabType}")
	public ResponseEntity<List<Cab>> getCabTypes(@PathVariable("cabType") String carType) throws InvalidCarTypeException {
		List<Cab> cabs = cabService.viewCabsOfType(carType);
		ResponseEntity<List<Cab>> response = new ResponseEntity<>(cabs, HttpStatus.OK);
		return response;
	}
	
	
}

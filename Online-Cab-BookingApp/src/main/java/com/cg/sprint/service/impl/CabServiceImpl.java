package com.cg.sprint.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.InvalidCarTypeException;
import com.cg.sprint.repository.CabRepository;
import com.cg.sprint.service.CabService;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	CabRepository cabRepository;
	
	@Override
	public Cab insertCab(Cab cab) {
		cabRepository.save(cab);
		return cab;
	}

	@Override
	public Cab updateCab(Cab cab) {
		Optional<Cab> cabOpt = cabRepository.findById(cab.getCabId());
		Cab cab1 = cabOpt.get();
		cab1.setCabId(cab.getCabId());
		cab1.setCarType(cab.getCarType());
		cab1.setPerKmRate(cab.getPerKmRate());
		cabRepository.save(cab1);
		return cab1;
	}

	@Override
	public void deleteCab(Long cabId) throws CabNotFoundException {
		try {
		cabRepository.deleteById(cabId);
		}
		catch(Exception ex)
		{
			throw new CabNotFoundException("Cab details Not Found.");
		}
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) throws InvalidCarTypeException {
		List<Cab>cab1=new ArrayList<>();
		try {
		List<Cab> cab =cabRepository.findAll();
		for(Cab cabop:cab)
		{
			if(cabop.getCarType().contentEquals(carType))
			{
				cab1.add(cabop);
			}
		}}
	    catch(Exception ex)
	    {
	    	throw new InvalidCarTypeException("Invalid car type.");
	    }
		return cab1;
	}

	@Override
	public Long countCabsOfType(String carType) throws InvalidCarTypeException{
		Long count=0L;
		try {
		List<Cab> cab =cabRepository.findAll();
		for(Cab cabop:cab)
		{
			if( cabop.getCarType().contentEquals(carType))
			{
				count++;
			}
		}}
		catch(Exception ex)
	    {
	    	throw new InvalidCarTypeException("Invalid car type.");
	    }
		return count;
	}

}

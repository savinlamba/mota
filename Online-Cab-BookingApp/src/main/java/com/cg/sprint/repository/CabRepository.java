package com.cg.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Cab;
import com.cg.sprint.entity.TripBooking;

public interface CabRepository extends JpaRepository<Cab, Long>{
}

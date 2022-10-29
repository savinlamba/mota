package com.cg.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{

	  Admin findUserByadminId(Long i);
	  Admin findUserByadminId(int adminid);
	  Admin findByAdminId(Long adminId);
}

package com.cg.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Admin extends User{
	@Id
	private Long adminId;

	
	public Admin(Long adminId, String username, String password, String email, String mobile, String address) {
		setAdminId(adminId);
		setUsername(username);
		setAddress(address);
		setMobileNumber(mobile);
		setEmail(email);
		setPassword(password);
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Admin() {
		super();
	}

	
}

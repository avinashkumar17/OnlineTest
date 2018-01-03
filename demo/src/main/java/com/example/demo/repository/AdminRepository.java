package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.String;

import com.example.demo.entity.AdminLogin;

import java.util.List;

public interface AdminRepository extends JpaRepository<AdminLogin, Integer> {

	@Query(nativeQuery = true, value = "select username,password,role,id, email, phonenumber from adminlogin where username=?1")
	public List<AdminLogin> findbyData(String val);

	@Query(nativeQuery = true, value = "select * from adminLogin where username=?1 and phonenumber=?2")
	public List<AdminLogin> findByUsernameandPhonenumber(String username, int phonenumber);
	// AdminLogin findByUsername(String username);

}

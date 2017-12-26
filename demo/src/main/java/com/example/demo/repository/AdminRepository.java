package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.String;

import com.example.demo.entity.AdminLogin;

import java.util.List;


public interface AdminRepository  extends JpaRepository<AdminLogin,Integer>{
	

	@Query(nativeQuery = true,
    value = "select username,password,role,id from adminlogin where username=?1")
	public List<AdminLogin> findbyData(String val);
	
	
	
	//AdminLogin findByUsername(String username);
	

}

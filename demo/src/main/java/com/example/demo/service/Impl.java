package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;




import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.AdminLogin;
import com.example.demo.entity.Category;
import com.example.demo.entity.Levels;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategoryRepository;




@Service("dao")
public class Impl implements Inter{

@Autowired AdminRepository adminrepo;

@Autowired CategoryRepository repo;



@Override
public List<AdminLogin> getAdminDetails(String val) {
	// TODO Auto-generated method stub
	
	return adminrepo.findbyData(val);
}




@Override
public List<Levels> insertData(Category c) {
	
	return repo.findByCategory(c);
	
}
	
	
}

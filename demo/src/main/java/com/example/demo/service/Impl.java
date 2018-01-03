package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AdminLogin;
import com.example.demo.entity.Category;
import com.example.demo.entity.Levels;
import com.example.demo.entity.Questions;
import com.example.demo.exception.UserAlreadyExist;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.LevelsRepository;
import com.example.demo.repository.QuestionRepository;

@Service("dao")
public class Impl implements Inter {

	@Autowired
	AdminRepository adminrepo;

	@Autowired
	CategoryRepository repo;
	
	@Autowired
	LevelsRepository levelRepo;
	
	@Autowired
	QuestionRepository questionRepo;

	@Override
	public List<AdminLogin> getAdminDetails(String val) {
		return adminrepo.findbyData(val);
	}

	@Override
	public List<Category> saveData(int id) {
		return repo.findData(id);
	}

	@Override
	public List<Category> findCategory() {
		return repo.findAll();
	}

	@Override
	public List<Questions> findLevel(Levels level) {
		// TODO Auto-generated method stub
		return questionRepo.findByLevel(level);
	}

	@Override
	public List<Levels> showLevel(int id) {
		// TODO Auto-generated method stub
		return levelRepo.showLevel(id);
	}

	@Override
	public String doSignUp(AdminLogin adminLogin) throws UserAlreadyExist{
			List<AdminLogin> resp =adminrepo.findByUsernameandPhonenumber(adminLogin.getUsername(), adminLogin.getPhonenumber());	
			if(resp.size()==0) {
				adminrepo.save(adminLogin);
				return "Successfully Registered";
			}else {
			 throw new UserAlreadyExist("User Already Exist");
			}
	}

}

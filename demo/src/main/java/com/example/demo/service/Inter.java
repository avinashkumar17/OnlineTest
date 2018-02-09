package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AdminLogin;
import com.example.demo.entity.Category;
import com.example.demo.entity.Levels;
import com.example.demo.entity.Questions;
import com.example.demo.exception.UserAlreadyExist;

public interface Inter {

	public List<AdminLogin> getAdminDetails(String val);

	public List<Category> saveData(int id);
	
	public List<Category> findCategory();
	
	public List<Questions> findLevel(int id);
	
	public List<Levels> showLevel(int id);
	
	public String doSignUp(AdminLogin adminLogin) throws UserAlreadyExist;
	
	public boolean addCategory(String categoryName);
	
	public boolean removeCategory(int categoryId);
	
	public boolean removeLevel(int levelId);
	
	public List<Category> findthree();
	
	public void editValue(int id, String category);
	
	public void editLevelValue(int id, String level);
	
	public String addQuestion(Questions q);
	
	public String addLevel(Levels q);
	
	public List<Levels> showAllLevel();
	
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AdminLogin;
import com.example.demo.entity.Category;
import com.example.demo.entity.Levels;


public interface Inter {



public List<AdminLogin> getAdminDetails(String val);

public List<Levels> insertData(Category t);
}

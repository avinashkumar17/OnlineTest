package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Levels;
import com.example.demo.entity.Category;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Levels,Long>{
	
	
List<Levels> findByCategory(Category category);
}
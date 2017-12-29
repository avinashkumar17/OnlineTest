package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Questions;
import com.example.demo.entity.Levels;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions,Long>{
	
	
List<Questions> findByLevel(Levels level);	

}

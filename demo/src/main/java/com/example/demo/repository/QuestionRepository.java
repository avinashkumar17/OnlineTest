package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Questions;
import com.example.demo.entity.Levels;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions,Long>{
	

@Query(nativeQuery = true,value="select * from questions where q_id=?1 order by rand() limit 3")	
List<Questions> findByLevelQuestion(int id);	

}

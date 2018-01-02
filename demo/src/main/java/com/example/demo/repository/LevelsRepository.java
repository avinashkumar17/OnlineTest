package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Levels;

public interface LevelsRepository extends JpaRepository<Levels, Long> {
	
	
	@Query(nativeQuery = true, value = "select * from levels where l_id=?1")
	public List<Levels> showLevel(int id);
	
	
}

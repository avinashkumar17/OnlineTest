package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Levels;

public interface LevelsRepository extends JpaRepository<Levels, Long> {

	@Query(nativeQuery = true, value = "select * from levels where l_id=?1")
	public List<Levels> showLevel(int id);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "insert into levels (level_category, l_id) values(?2, ?1)")
	public void addLevel(int id, String level);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE levels SET level_category=?1 WHERE id =?2")
	public void updateLevel(String level, int id);
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Category;

import java.util.List;
import java.lang.String;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery = true, value = "select * from category where id=?1")
	public List<Category> findData(int id);

	@Query(nativeQuery = true, value = "delete from category where id=?1")
	public String deleteId(int category);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE category SET category=?1 WHERE id =?2")
	public void updateCategory(String category, int id);

}

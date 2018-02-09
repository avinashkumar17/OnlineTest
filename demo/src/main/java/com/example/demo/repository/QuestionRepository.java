package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Long> {

	@Query(nativeQuery = true, value = "select * from questions where q_id=?1 order by rand() limit 3")
	List<Questions> findByLevelQuestion(int id);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value="insert into questions(question, answer, choice_a, choice_b, choice_c, choice_d, q_id) values (?1,?2,?3,?4,?5,?6,?7)")
	public void addQuestion(String question, String answer, String choicea, String choiceb,String choicec,String choiced,int q_id);
}

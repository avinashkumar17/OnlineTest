package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questions")
public class Questions {

	
	public Questions() {
		
	}
	public Questions(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String question;
	private String answer;
	private String choice_a;
	private String choice_b;
	private String choice_c;
	private String choice_d;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "q_id", referencedColumnName = "id")
	private Levels level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getChoice_a() {
		return choice_a;
	}

	public void setChoice_a(String choice_a) {
		this.choice_a = choice_a;
	}

	public String getChoice_b() {
		return choice_b;
	}

	public void setChoice_b(String choice_b) {
		this.choice_b = choice_b;
	}

	public String getChoice_c() {
		return choice_c;
	}

	public void setChoice_c(String choice_c) {
		this.choice_c = choice_c;
	}

	public String getChoice_d() {
		return choice_d;
	}

	public void setChoice_d(String choice_d) {
		this.choice_d = choice_d;
	}

	public Levels getLevel() {
		return level;
	}

	public void setLevel(Levels level) {
		this.level = level;
	}
}

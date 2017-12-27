package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "levels")
public class Levels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "level_category")
	private String levelCategory;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "l_id", referencedColumnName = "id")
	private Category category;

	@OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Questions> questionsItem = new ArrayList<Questions>();

	public List<Questions> getQuestionsItem() {
		return questionsItem;
	}

	public void setQuestionsItem(List<Questions> questionsItem) {
		this.questionsItem = questionsItem;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLevelCategory() {
		return levelCategory;
	}

	public void setLevelCategory(String levelCategory) {
		this.levelCategory = levelCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}

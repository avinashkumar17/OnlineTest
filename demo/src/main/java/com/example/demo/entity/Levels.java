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

@Entity
@Table(name="levels")
public class Levels {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="level_category")
	private String levelCategory;
	
	 @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 @JoinColumn(name="l_id", referencedColumnName="id")
	 private Category category;

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
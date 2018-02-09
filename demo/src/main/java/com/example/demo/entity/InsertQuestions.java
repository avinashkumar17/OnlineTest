package com.example.demo.entity;

import java.util.List;

public class InsertQuestions {
	
	private int id;
	private int levelId;
	private List<Questions> items;
	
	public int getCategoryId() {
		return id;
	}
	public void setCategoryId(int id) {
		this.id = id;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public List<Questions> getItems() {
		return items;
	}
	public void setItems(List<Questions> items) {
		this.items = items;
	}
	
	

}

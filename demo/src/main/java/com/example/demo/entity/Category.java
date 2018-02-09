package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "category")
	private String Category;

	public Category() {
	}
		
	public Category(int id,String category) {
		Id = id;
		Category = category;
	}

	public Category(String category) {
		Category = category;
	}

	@JsonIgnore
	@OneToMany(orphanRemoval = true, mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Levels> items = new ArrayList<Levels>();

	public List<Levels> getItems() {
		return items;
	}

	public void setItems(List<Levels> items) {
		this.items = items;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

}

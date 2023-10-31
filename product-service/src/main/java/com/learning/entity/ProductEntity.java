package com.learning.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.learning.enums.Category;

@Entity
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate date;
	private LocalTime time;

	@Enumerated(EnumType.STRING)
	private Category category;

	public ProductEntity() {

	}

	public ProductEntity(Long id, String name, LocalDate date, LocalTime time, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + ", category=" + category + "]";
	}

}

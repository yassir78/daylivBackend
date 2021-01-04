package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class CategoryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String category_name;
	@ManyToMany
	private List<Product> products;
}

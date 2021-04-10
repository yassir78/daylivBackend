package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String category_name;
	private String storeCode;
	@JsonIgnore
	@OneToMany(mappedBy = "categoryProduct")
	private List<Product> products;
}

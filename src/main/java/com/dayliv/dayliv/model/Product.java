package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String libelle;
	@NotNull
	private String description;
	@NotNull
	private String stock_quantity;
	@NotNull
	private Float price;
	private String origine;
	private Float poids;
	private Integer caloris;
	@OneToOne
	private PanierItem panierItem;
	@ManyToMany(mappedBy = "products")
	@NotNull
	private List<CategoryProduct> categoryProducts;
	@OneToMany(mappedBy = "product")
	private List<Ingredient> ingredients;
	@OneToOne
	private CommandeItem commandeItem;
	@ManyToOne
	private Partenaire partenaire;
	@OneToMany(mappedBy = "product")
	private List<Ingredient> products;
}

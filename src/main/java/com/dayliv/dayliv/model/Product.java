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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String libelle;
	@NotNull
	private String description;
	@NotNull
	private Integer stock_quantity;
	@NotNull
	private Float price;
	private String origine;
	private String image;
	private Float poids;
	private Integer caloris;
	@OneToOne
	private PanierItem panierItem;
	@ManyToMany(mappedBy = "products")
	private List<CategoryProduct> categoryProducts;
	@OneToMany(mappedBy = "product")
	private List<Ingredient> ingredients;
	@OneToOne
	private CommandeItem commandeItem;
	@ManyToOne
	private Partenaire partenaire;
	@OneToMany(mappedBy = "product")
	private List<Ingredient> products;
	@OneToMany(mappedBy = "product")
	private List<Commentaire> commentaires;
}

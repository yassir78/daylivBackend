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

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Long id_image;
	private Float poids;
	@OneToOne
	private ImageModel imageModel;
	private Integer caloris;
	@OneToOne
	@JsonIgnore
	private PanierItem panierItem;
	@ManyToMany(mappedBy = "products")
	@JsonIgnore
	private List<CategoryProduct> categoryProducts;
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Ingredient> ingredients;
	@OneToOne
	@JsonIgnore
	private CommandeItem commandeItem;
	@ManyToOne
	private Partenaire partenaire;
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Commentaire> commentaires;
}

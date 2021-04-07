package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Column;
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
	@Column(length = 1000)
	private String description;
	private Integer stock_quantity;
	@NotNull
	private Float price;
	private String origine;
	private String image;
	private String storeCode;
	private Float poids;
	private Integer caloris;
	@OneToOne
	@JsonIgnore
	private PanierItem panierItem;
	@ManyToOne
	private CategoryProduct categoryProduct;
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

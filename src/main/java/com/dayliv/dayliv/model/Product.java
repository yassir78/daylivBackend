package com.dayliv.dayliv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}

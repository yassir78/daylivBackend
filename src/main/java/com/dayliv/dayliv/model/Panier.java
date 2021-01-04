package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float totale;
	@OneToOne
	private Consumer consumer;
	@OneToMany(mappedBy = "panier")
	private List<PanierItem> panierItems;
}

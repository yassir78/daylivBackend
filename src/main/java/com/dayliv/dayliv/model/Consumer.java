package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne
	private Panier panier;
	@OneToMany(mappedBy = "consumer")
	private List<Commande> commandes;
	@OneToMany(mappedBy = "consumer")
	private List<Paiement> paiements;
}

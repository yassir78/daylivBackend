package com.dayliv.dayliv.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

@Entity
public class Paiement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private Date date_paiement;
	@NotNull
	private Float total;
	@ManyToOne
	private Consumer consumer;
	@OneToOne
	private Commande commande;
}

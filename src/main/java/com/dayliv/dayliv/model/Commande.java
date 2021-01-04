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
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    @NotNull
	private String reference;
    @NotNull
	private Float totale_commande;
    @NotNull
	private Date date_commande;
	@ManyToOne
	private Consumer consumer;
	@ManyToOne
	private CommandeStatus commandeStatus;
	@OneToOne
	private Paiement paiement;
}

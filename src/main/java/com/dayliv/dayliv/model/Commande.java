package com.dayliv.dayliv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	@OneToMany(mappedBy = "commande")
	private List<CommandeItem> commandeItems;
}
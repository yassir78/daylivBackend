package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("consumer")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Consumer extends User {
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Panier panier;
	@OneToMany(mappedBy = "consumer")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Commande> commandes;
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "consumer")
	private List<Paiement> paiements;
	
	
	

}

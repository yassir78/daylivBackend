package com.dayliv.dayliv.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("livreur")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Livreur extends User{
	private String card_id;
	private String mobility;
	@OneToOne
	private Commande commande;
	private double lg;
	private double lat;
	
	
}

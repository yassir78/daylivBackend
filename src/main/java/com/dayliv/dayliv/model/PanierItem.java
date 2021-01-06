package com.dayliv.dayliv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PanierItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Integer qte;
	private Float total_panier;
	@ManyToOne
	private Panier panier;
	@OneToOne
	private Product produit;
}

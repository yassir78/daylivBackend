package com.dayliv.dayliv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivraisonInfos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private String adresseLivraison;
	private String adresseFacture;
	private String ville;
	private String tel;
	private String email;
	private String batiment;
	private String interphone;
	private String typeLivraison;
	private String fraisLivraison;
	private String fraisGrosVolume;
	private String dateLivraison;
	private String etage;
	private String codePostal;
	private String pays;

}

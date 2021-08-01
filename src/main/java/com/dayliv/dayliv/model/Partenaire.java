package com.dayliv.dayliv.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("partenaire")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Partenaire extends User {
	private String description;
	private String banniere;
	private Long latitude;
	private Long longitude;
	private String defaultLanguage = "FR";//code
	private String currency ="CH";//code
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date inBusinessSince;
	@OneToMany(mappedBy = "partenaire")
	@JsonIgnore
	private List<Product> products;
	@ManyToMany
	@JsonIgnore
	private List<CategoryPartenaire> categoryPartenaires;
	@OneToOne
	private Store store;
	private String adresse;
	@OneToMany(mappedBy = "partenaire")
	@JsonIgnore
	private List<Commande> commandes;
    @ManyToOne
	private CategoryStore categoryStore;


}

package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String code;
	@NotNull
	private String name;
	@NotNull
	private String logo;
	private String defaultLanguage;//code
	private String currency;//code
	private String inBusinessSince;
	private String codePostal;
	private String address;
	@NotNull
	private String email;
	@NotNull
	private String phone;
	private String description;
    private boolean useCache;
	private double lg;
	private double lat;
	@OneToOne
	private Partenaire partenaire ;
	@OneToMany(mappedBy = "store")
	@JsonIgnore
	private List<Commande> commandes;
}

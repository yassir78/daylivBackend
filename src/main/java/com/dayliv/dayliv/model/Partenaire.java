package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("partenaire")
public class Partenaire  extends User{
	private String description;
	private String banniere;
	@OneToMany(mappedBy = "partenaire")
	private List<Product> products;
	@ManyToMany
	private List<CategoryPartenaire> categoryPartenaires;
}

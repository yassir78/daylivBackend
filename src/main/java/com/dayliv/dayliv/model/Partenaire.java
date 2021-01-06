package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("partenaire")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Partenaire  extends User{
	private String description;
	private String banniere;
	@OneToMany(mappedBy = "partenaire")
	private List<Product> products;
	@ManyToMany
	private List<CategoryPartenaire> categoryPartenaires;
}

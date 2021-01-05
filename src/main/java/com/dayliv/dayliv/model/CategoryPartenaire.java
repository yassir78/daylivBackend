package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CategoryPartenaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Size(min = 5)
	private String caregory_partenaire_name;
	@ManyToMany(mappedBy = "categoryPartenaires")
	private List<Partenaire> partenaires;

}

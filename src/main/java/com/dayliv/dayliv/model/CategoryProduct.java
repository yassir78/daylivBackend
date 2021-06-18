package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.slugify.Slugify;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String categorie;
	private String label;
	private String icon;
	private String link;
	private String storeCode;
	@JsonIgnore
	@OneToMany(mappedBy = "categoryProduct")
	private List<Product> products;
	@OneToMany(mappedBy = "categoryProduct")
	private List<SubCategory> sousCategories;
	 
    @PrePersist
    public void slugify(){
    	this.label = this.categorie;
        this.link = new Slugify().slugify(this.label);
    }
}

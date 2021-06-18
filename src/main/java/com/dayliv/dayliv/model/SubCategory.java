package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.slugify.Slugify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String sousCategorie;
	private String storeCode;
	private String label;
	private String faIcon;
	private String link;
	@JsonIgnore
	@ManyToOne
	private CategoryProduct categoryProduct;
	@JsonIgnore
	@OneToMany(mappedBy = "subCategory")
	private List<Product> products;
	@PrePersist
    public void slugify(){
    	this.label = this.sousCategorie;
        this.link = new Slugify().slugify(this.label);
    }
}

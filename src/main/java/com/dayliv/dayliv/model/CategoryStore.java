package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.slugify.Slugify;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CategoryStore {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String nom;
private String label;
private String icon;
private String link;
private String storeCode;
@OneToMany(mappedBy = "categoryStore")
@JsonIgnore
private List<Store> stores;

@OneToMany(mappedBy = "categoryStore")
@JsonIgnore
private List<Partenaire> partenaires;

@PrePersist
public void slugify(){
	this.label = this.nom;
    this.link = new Slugify().slugify(this.label);
}
}

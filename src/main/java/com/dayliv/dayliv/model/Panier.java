package com.dayliv.dayliv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private float totale;
	@OneToOne
	@JsonIgnore
	private Consumer consumer;
	@OneToMany(mappedBy = "panier")
	@JsonIgnore
	private List<PanierItem> panierItems;
}

package com.dayliv.dayliv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class CommandeItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Integer quantity;
    private Float total;
    @OneToOne
    private Product product;
    @ManyToOne
    @JsonIgnore
    private Commande commande;
}

package com.dayliv.dayliv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CommandeItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Integer quantity;
    private Float total;
    @OneToOne
    private Product product;	
}

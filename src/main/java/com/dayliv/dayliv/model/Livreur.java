package com.dayliv.dayliv.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("livreur")
public class Livreur extends User{
	private String card_id;
	private String mobility;
}

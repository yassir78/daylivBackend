package com.dayliv.dayliv.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("superAdmin")
public class SuperAdmin extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
}

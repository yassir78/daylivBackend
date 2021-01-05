package com.dayliv.dayliv.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="type", discriminatorType = DiscriminatorType.STRING )
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	private String login;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String c_password;
	@NotNull
	private String image_profile;
	private String num_tel;
	@NotNull
	private boolean active;

	
  
}

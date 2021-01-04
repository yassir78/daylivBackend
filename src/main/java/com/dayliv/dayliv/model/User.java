package com.dayliv.dayliv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private String login;
	private String email;
	private String password;
	private String c_password;
	private String image_profile;
	private String num_tel;
	private boolean active;

	
  
}

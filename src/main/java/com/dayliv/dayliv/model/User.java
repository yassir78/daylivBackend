package com.dayliv.dayliv.model;

import javax.persistence.Transient;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name="type", discriminatorType = DiscriminatorType.STRING )
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	
	// Not persistent. There is no column on database table.
	@Transient
	private String token;
	@Enumerated(EnumType.STRING)
	private Role role;
	

  
}

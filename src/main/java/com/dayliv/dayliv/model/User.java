package com.dayliv.dayliv.model;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	public User(String userID, String password2, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	
	private String prenom;
	private String login;
	private String providerUserId;
	private String email;
	
	private String password;
	
	private String c_password;
	
	private String image_profile;
	
	private String num_tel;
	
	@Column(name = "enabled", columnDefinition = "BIT", length = 1)
	private boolean enabled;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	@Column(name = "created_date", nullable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;
	private String provider;
	
	// Not persistent. There is no column on database table.
	@Transient
	private String token;
	@Enumerated(EnumType.STRING)
	private ERole role;
	
	// bi-directional many-to-many association to Role
		@JsonIgnore
		@ManyToMany
		@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
		private Set<Role> roles;
	}
	

  


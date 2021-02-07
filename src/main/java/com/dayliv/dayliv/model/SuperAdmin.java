package com.dayliv.dayliv.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("superAdmin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SuperAdmin extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}

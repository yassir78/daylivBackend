package com.dayliv.dayliv.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String body;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YY, HH:mm")
	private Date createdAt = new Date();
	private String path;
	private String client;
	private Boolean seen;
	@ManyToOne
	@JsonIgnore
	private User user;
}

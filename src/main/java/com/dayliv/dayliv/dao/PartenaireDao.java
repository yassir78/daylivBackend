package com.dayliv.dayliv.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.model.Partenaire;
@Repository
@CrossOrigin
public interface PartenaireDao  extends JpaRepository<Partenaire,Long>{
	public Partenaire  findByLogin(String nom); 
	public Partenaire findByNom(String nom);
}

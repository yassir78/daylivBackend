package com.dayliv.dayliv.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.model.Livreur;

import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.Store;
@Repository
@CrossOrigin
public interface PartenaireDao  extends JpaRepository<Partenaire,Long>{
	public Partenaire  findByLogin(String nom); 
	public Partenaire findByNom(String nom);
	public Partenaire findByStoreCode(String code);
	public Page<Partenaire> findByNomContaining(String name, Pageable pageable);
	public List<Partenaire> findAllByCategoryStoreLink(String link);
	

}

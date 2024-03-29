package com.dayliv.dayliv.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.model.Livreur;
@Repository
@CrossOrigin
public interface LivreurDao extends JpaRepository<Livreur,Long>{
	public Optional<Consumer>  findByLogin(String nom); 
	public Livreur findByNom(String nom);
	public Livreur findByEmail(String email);
	 Page<Livreur> findByNomContaining(String name, Pageable pageable);
	


}

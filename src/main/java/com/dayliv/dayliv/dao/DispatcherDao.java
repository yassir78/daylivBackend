package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.model.Partenaire;
@Repository
@CrossOrigin
public interface DispatcherDao extends JpaRepository<Dispatcher ,Long>{
	public Dispatcher  findByLogin(String nom); 
	public Dispatcher findByNom(String nom);
}

package com.dayliv.dayliv.service;

import java.security.Principal;
import java.util.List;

import com.dayliv.dayliv.model.Livreur;

public interface LivreurService {
	public List<Livreur> findAll();

	public Livreur save(Livreur livreur);

	public void delete(Long id);

	public Livreur update(Long id, Livreur livreur);

	public Livreur findByNom(String nom);

	public Livreur findById(Long id);

	public Livreur findByLogin(String login);
}

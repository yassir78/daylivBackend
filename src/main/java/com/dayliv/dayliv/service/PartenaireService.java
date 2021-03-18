package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Partenaire;

public interface PartenaireService {
	public List<Partenaire> findAll();

	public Partenaire save(Partenaire partenaire);

	public int delete(Long id);

	public Partenaire update(Long id, Partenaire partenaire);

	public Partenaire findByNom(String nom);

	public Partenaire findById(Long id);

	public Partenaire findByLogin(String login);

}

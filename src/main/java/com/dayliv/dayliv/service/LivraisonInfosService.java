package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.LivraisonInfos;

public interface LivraisonInfosService {
	public List<LivraisonInfos> findAll();

	public LivraisonInfos save(LivraisonInfos livraisonInfos);
	
	public void delete(Long id);

	public LivraisonInfos update(Long id, LivraisonInfos livraisonInfos);

	public LivraisonInfos findByNom(String nom);

	public LivraisonInfos findById(Long id);
}

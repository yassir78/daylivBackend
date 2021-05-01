package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeItem;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.model.Livreur;

public interface CommandeService {
	public List<Commande> findAll();
	public Commande save(Commande commande);
	public Commande affecterCommandeLivreur(Livreur livreur,Long id);
	public List<Commande> getCommandeByLivreur(Long id);
	public List<Commande> findAllByStoreCode(String storeCode);
	public Commande changeStatus(String status,Long id);
}

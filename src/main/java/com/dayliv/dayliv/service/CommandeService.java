package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeItem;

public interface CommandeService {
	public List<Commande> findAll();
	public Commande save(Commande commande);
}

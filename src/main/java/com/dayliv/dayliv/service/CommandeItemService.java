package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeItem;

public interface CommandeItemService {
	public List<CommandeItem> findAll();
	public void saveCommandeItems(Commande commande,List<CommandeItem> commandeItems);
}

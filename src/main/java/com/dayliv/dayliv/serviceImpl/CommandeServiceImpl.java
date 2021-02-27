package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommandeDao;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.service.CommandeItemService;
import com.dayliv.dayliv.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDao commandeDao;
	@Autowired
	private CommandeItemService commandeItemService;

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return commandeDao.findAll();
	}

	@Override
	public Commande save(Commande commande) {
		// TODO Auto-generated method stub
		commandeDao.save(commande);
		if (commande.getCommandeItems() != null) {
			commandeItemService.saveCommandeItems(commande, commande.getCommandeItems());
		}
		return commande;
	}

}

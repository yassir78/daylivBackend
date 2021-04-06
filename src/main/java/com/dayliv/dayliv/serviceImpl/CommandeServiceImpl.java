package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommandeDao;
import com.dayliv.dayliv.dao.LivreurDao;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.CommandeItemService;
import com.dayliv.dayliv.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDao commandeDao;
	@Autowired
	private CommandeItemService commandeItemService;
	@Autowired
	private LivreurDao livreurDao;

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

	@Override
	public Commande affecterCommandeLivreur(Livreur livreur, Long id) {
		// TODO Auto-generated method stub
		Commande commande = commandeDao.findById(id).get();
		if (commande != null) {
			commande.setLivreur(livreur);
			commandeDao.save(commande);
			return commande;

		}
		return null;
	}

	@Override
	public List<Commande> getCommandeByLivreur(Long id) {
		// TODO Auto-generated method stub
		Livreur livreur = livreurDao.findById(id).get();

		System.out.println("hello world" + livreur.getId());
		if (livreur != null) {
			List<Commande> commandes = commandeDao.findByLivreur(livreur);
			return commandes;

		}
		return null;
	}

}

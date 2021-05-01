package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommandeDao;
import com.dayliv.dayliv.dao.CommandeStatusDao;
import com.dayliv.dayliv.dao.LivraisonInfosDao;
import com.dayliv.dayliv.dao.LivreurDao;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.model.LivraisonInfos;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.CommandeItemService;
import com.dayliv.dayliv.service.CommandeService;
import com.dayliv.dayliv.service.CommandeStatusService;
import com.dayliv.dayliv.service.LivraisonInfosService;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDao commandeDao;
	@Autowired
	private CommandeItemService commandeItemService;
	@Autowired
	private CommandeStatusService CommandeStatusService;
	@Autowired
	private LivreurDao livreurDao;
	@Autowired
	private LivraisonInfosService livraisonInfosService;
	@Autowired
	private CommandeStatusDao commandeStatusDao;

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return commandeDao.findAll();
	}

	@Override
	public Commande save(Commande commande) {

		// TODO Auto-generated method stub
		LivraisonInfos livraisonInfos = commande.getLivraisonInfos();
		CommandeStatus commandeStatus = commande.getCommandeStatus();
		if (livraisonInfos != null) {
			System.out.println(livraisonInfos);
			commande.setLivraisonInfos(livraisonInfos);
			livraisonInfosService.save(livraisonInfos);

		}
		if (commandeStatus != null) {
			System.out.println(commandeStatus);
			commande.setCommandeStatus(commandeStatus);
			CommandeStatusService.save(commandeStatus);

		}

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
		List<Commande> commandes = commandeDao.findByLivreur(livreur);
		return commandes;
	}

	@Override
	public Commande changeStatus(String status, Long id) {
		// TODO Auto-generated method stub
		Commande commande = commandeDao.findById(id).get();
		if (commande != null) {
			CommandeStatus commandeStatus = commande.getCommandeStatus();
			commandeStatus.setEtat_commande(status);
			commandeStatusDao.save(commandeStatus);

		}
		return null;
	}

	@Override
	public List<Commande> findAllByStoreCode(String storeCode) {
		return commandeDao.findAllByStoreCode(storeCode);
	}

}

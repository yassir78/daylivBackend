package com.dayliv.dayliv.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommandeDao;
import com.dayliv.dayliv.dao.CommandeStatusDao;
import com.dayliv.dayliv.dao.LivraisonInfosDao;
import com.dayliv.dayliv.dao.LivreurDao;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.model.LivraisonInfos;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Product;
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
		System.out.println("LIVRAISON INFOS");
		if (livraisonInfos != null) {
			System.out.println("///////////////////////////////");
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
		return commande;
	}

	@Override
	public List<Commande> findAllByStoreCode(String storeCode) {
		return commandeDao.findAllByStoreCode(storeCode);
	}

	@Override
	public Map<String, Object> getAllCommandes(String name, int page, int size) {
		 List<Commande> commandes = new ArrayList<Commande>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Commande> pagecats;
	      if (name == null)
	    	  pagecats = commandeDao.findAll(paging);
	      else
	    	  pagecats = commandeDao.findByReferenceContaining(name, paging);

	      commandes = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("commandes", commandes);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
	}

}

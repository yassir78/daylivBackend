package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommandeItemDao;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeItem;
import com.dayliv.dayliv.service.CommandeItemService;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {
	@Autowired
	private CommandeItemDao commandeItemDao;

	@Override
	public List<CommandeItem> findAll() {
		// TODO Auto-generated method stub
		return commandeItemDao.findAll();
	}

	@Override
	public void saveCommandeItems(Commande commande, List<CommandeItem> commandeItems) {
		// TODO Auto-generated method stub
		for(CommandeItem commandeItem : commandeItems) {
			 commandeItem.setCommande(commande);
			 commandeItemDao.save(commandeItem);
		}
	}

}

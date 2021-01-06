package com.dayliv.dayliv.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommandeDao;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDao commandeDao;

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return commandeDao.findAll();
	}

}

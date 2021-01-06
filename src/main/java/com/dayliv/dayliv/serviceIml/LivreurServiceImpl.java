package com.dayliv.dayliv.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.LivreurDao;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.LivreurService;
@Service
public class LivreurServiceImpl implements LivreurService {
	@Autowired
	private LivreurDao livreurDao;

	@Override
	public List<Livreur> findAll() {
		// TODO Auto-generated method stub
		return livreurDao.findAll();
	}

	@Override
	public Livreur save(Livreur livreur) {
		// TODO Auto-generated method stub
		return livreurDao.save(livreur);
	}

}

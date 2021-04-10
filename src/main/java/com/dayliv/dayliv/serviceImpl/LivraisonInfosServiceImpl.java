package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.LivraisonInfosDao;
import com.dayliv.dayliv.model.LivraisonInfos;
import com.dayliv.dayliv.service.LivraisonInfosService;
@Service
public class LivraisonInfosServiceImpl implements LivraisonInfosService {
   @Autowired
   private LivraisonInfosDao livraisonInfosDao;
	@Override
	public List<LivraisonInfos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivraisonInfos save(LivraisonInfos livraisonInfos) {
		return this.livraisonInfosDao.save(livraisonInfos);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LivraisonInfos update(Long id, LivraisonInfos livraisonInfos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivraisonInfos findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivraisonInfos findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

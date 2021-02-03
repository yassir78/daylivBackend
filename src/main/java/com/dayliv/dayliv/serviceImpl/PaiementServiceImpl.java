package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.PaiementDao;
import com.dayliv.dayliv.model.Paiement;
import com.dayliv.dayliv.service.PaiementService;

@Service
public class PaiementServiceImpl implements PaiementService {
	@Autowired
	private PaiementDao PaiementDao;

	@Override
	public List<Paiement> findAll() {
		// TODO Auto-generated method stub
		return PaiementDao.findAll();
	}

}

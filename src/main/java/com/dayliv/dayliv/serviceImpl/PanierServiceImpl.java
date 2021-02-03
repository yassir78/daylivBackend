package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.PanierDao;
import com.dayliv.dayliv.model.Panier;
import com.dayliv.dayliv.service.PanierService;

@Service
public class PanierServiceImpl implements PanierService{
    @Autowired
    private PanierDao PanierDao;

	@Override
	public List<Panier> findAll() {
		// TODO Auto-generated method stub
		return PanierDao.findAll();
	}

}

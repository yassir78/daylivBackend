package com.dayliv.dayliv.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.PanierItemDao;
import com.dayliv.dayliv.model.PanierItem;
import com.dayliv.dayliv.service.PanierItemService;

@Service
public class PanierItemServiceImpl implements PanierItemService {
	@Autowired
	private PanierItemDao panierItemDao;

	@Override
	public List<PanierItem> findAll() {
		// TODO Auto-generated method stub
		return panierItemDao.findAll();
	}

}

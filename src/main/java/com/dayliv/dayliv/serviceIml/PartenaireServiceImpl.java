package com.dayliv.dayliv.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.PartenaireDao;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.service.PartenaireService;

@Service
public class PartenaireServiceImpl implements PartenaireService {
	@Autowired
    private PartenaireDao partenaireDao;
	@Override
	public List<Partenaire> findAll() {
		// TODO Auto-generated method stub
		return partenaireDao.findAll();
	}

}

package com.dayliv.dayliv.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CategoryPartenaireDao;
import com.dayliv.dayliv.model.CategoryPartenaire;
import com.dayliv.dayliv.service.CategoryPartenaireService;

@Service
public class CategoryPartenaireServiceImpl implements CategoryPartenaireService {
	@Autowired
	private CategoryPartenaireDao categoryPartenaireDao;

	@Override
	public List<CategoryPartenaire> findAll() {
		// TODO Auto-generated method stub
		return categoryPartenaireDao.findAll();
	}

}

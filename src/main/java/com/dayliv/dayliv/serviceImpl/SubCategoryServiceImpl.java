package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.SubCategoryDao;
import com.dayliv.dayliv.model.SubCategory;
import com.dayliv.dayliv.service.SubCategoryService;
@Service
public class SubCategoryServiceImpl implements SubCategoryService{
   @Autowired
   private SubCategoryDao subCategoryDao;
	@Override
	public List<SubCategory> findAll() {
		return subCategoryDao.findAll();
	}

	@Override
	public SubCategory save(SubCategory subCategory) {
		return subCategoryDao.save(subCategory);
	}

}

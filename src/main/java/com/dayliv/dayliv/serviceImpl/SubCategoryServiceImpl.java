package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.StoreDao;
import com.dayliv.dayliv.dao.SubCategoryDao;
import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.model.SubCategory;
import com.dayliv.dayliv.service.SubCategoryService;
@Service
public class SubCategoryServiceImpl implements SubCategoryService{
   @Autowired
   private SubCategoryDao subCategoryDao;
   @Autowired
	private StoreDao storeDao;
	@Override
	public List<SubCategory> findAll() {
		return subCategoryDao.findAll();
	}

	@Override
	public SubCategory save(SubCategory subCategory) {
		return subCategoryDao.save(subCategory);
	}
	@Override
	public List<SubCategory> getSubCategoriesByStoreCode(String code) {
		Store store = storeDao.findByCode(code);
		if (store != null) {
			return subCategoryDao.findByStoreCode(code);
		}
		return null;
	}
}

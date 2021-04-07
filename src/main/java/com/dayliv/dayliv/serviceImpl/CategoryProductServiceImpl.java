package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CategoryProductDao;
import com.dayliv.dayliv.dao.StoreDao;
import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.service.CategoryProductService;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
	@Autowired
	private CategoryProductDao categoryProductDao;
	@Autowired
	private StoreDao storeDao;

	@Override
	public List<CategoryProduct> findAll() {
		// TODO Auto-generated method stub
		return categoryProductDao.findAll();
	}

	@Override
	public List<CategoryProduct> getCategoriesByStoreCode(String code) {
		// TODO Auto-generated method stub
		Store store = storeDao.findByCode(code);
		if (store != null) {
			return store.getCategoryProducts();
		}
		return null;
	}

}

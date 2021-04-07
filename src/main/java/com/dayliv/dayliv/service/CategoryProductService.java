package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.CategoryProduct;

public interface CategoryProductService {
	public List<CategoryProduct> findAll();
	public List<CategoryProduct> getCategoriesByStoreCode(String code);
}

package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;

import com.dayliv.dayliv.model.CategoryProduct;

public interface CategoryProductService {
	public List<CategoryProduct> findAll();

	public List<CategoryProduct> getCategoriesByStoreCode(String code);

	public CategoryProduct save(CategoryProduct categoryProduct);
	
	public Map<String, Object> getAllCategories(String name, int page, int size);

}

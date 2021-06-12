package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.SubCategory;

public interface SubCategoryService {
	public List<SubCategory> findAll();
	public List<SubCategory> getSubCategoriesByStoreCode(String code);
	public SubCategory save(SubCategory subCategory);
}

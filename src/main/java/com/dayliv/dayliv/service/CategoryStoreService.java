
package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;

import com.dayliv.dayliv.model.CategoryStore;

public interface CategoryStoreService {
	public List<CategoryStore> findAll();
	public Map<String, Object> getAllCategories(String name, int page, int size);
}

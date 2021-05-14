package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dayliv.dayliv.model.CategoryPartenaire;

public interface CategoryPartenaireService {
	public List<CategoryPartenaire> findAll();
	public Map<String, Object> getAllCategories(String name, int page, int size);
}

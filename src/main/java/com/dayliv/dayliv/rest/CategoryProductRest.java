package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.service.CategoryProductService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/categoryProduct")
public class CategoryProductRest {
	@Autowired
	private CategoryProductService categoryProductService;

	@GetMapping("/")
	public List<CategoryProduct> findAll() {
		return categoryProductService.findAll();
	}

	@GetMapping("/storeCode/{storeCode}")
	public List<CategoryProduct> getCategoriesByStoreCode(@PathVariable String storeCode) {
		return categoryProductService.getCategoriesByStoreCode(storeCode);
	}

}

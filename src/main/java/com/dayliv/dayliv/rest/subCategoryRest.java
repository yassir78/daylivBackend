package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.SubCategory;
import com.dayliv.dayliv.service.SubCategoryService;

@RestController
public class subCategoryRest {
@Autowired
private SubCategoryService subCategoryService;

@GetMapping("/")
public List<SubCategory> findAll() {
	return subCategoryService.findAll();
}


@PostMapping("/")
public SubCategory save(@RequestBody SubCategory subCategory) {
	return subCategoryService.save(subCategory);
}
}

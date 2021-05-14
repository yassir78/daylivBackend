package com.dayliv.dayliv.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping("/")
	public CategoryProduct save(@RequestBody CategoryProduct categoryProduct) {
		return categoryProductService.save(categoryProduct);
	}
	

	@GetMapping("/categories")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(categoryProductService.getAllCategories(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}

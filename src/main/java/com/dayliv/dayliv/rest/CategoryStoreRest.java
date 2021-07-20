
package com.dayliv.dayliv.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.CategoryStore;
import com.dayliv.dayliv.service.CategoryStoreService;

@RestController
@RequestMapping("/dayliv-api/categoryStore")
public class CategoryStoreRest {
	@Autowired
	private CategoryStoreService categoryStoreService;

	@GetMapping("/")
	public List<CategoryStore> findAll() {
		return categoryStoreService.findAll();
	}
	
	@GetMapping("/categories")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(categoryStoreService.getAllCategories(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
}

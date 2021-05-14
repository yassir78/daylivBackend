package com.dayliv.dayliv.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.CategoryPartenaire;
import com.dayliv.dayliv.service.CategoryPartenaireService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/categoryPartenaire")
public class CategoryPartenaireRest {
	@Autowired
	private CategoryPartenaireService categoryPartenaireService;

	@GetMapping("/")
	public List<CategoryPartenaire> findAll() {
		return categoryPartenaireService.findAll();
	}
	
	@GetMapping("/categories")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(categoryPartenaireService.getAllCategories(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
}

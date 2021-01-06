package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

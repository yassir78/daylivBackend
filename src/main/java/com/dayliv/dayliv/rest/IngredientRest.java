package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Ingredient;
import com.dayliv.dayliv.service.IngredientService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/ingredient")
public class IngredientRest {
	@Autowired
	private IngredientService ingredientService;

	@GetMapping("/")
	public List<Ingredient> findAll() {
		return ingredientService.findAll();
	}

}

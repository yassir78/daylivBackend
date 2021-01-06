package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/product")
public class ProductRest {
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public List<Product> findAll() {
		return productService.findAll();
	}

}

package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Product;

public interface ProductService {
  
	public List<Product> findAll();
	
	public Product createProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public int deleteProduct(Long id);
}

package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;

import com.dayliv.dayliv.model.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product createProduct(Product product, String idUser);

	public Product updateProduct(Product product);

	public int deleteProduct(Long id);
	public List<Product> getProductsRandomly();
	public Product findById(Long id);

	public List<Product> getProductsByStore(String storeCode);
    
	public Map<String, Object> findProductsBySubCategoryLink(String link, String storeCode, int page, int size);
	
	public Map<String, Object> getAllProducts(String name, String storeCode, int page, int size);

}

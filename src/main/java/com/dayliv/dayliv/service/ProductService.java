package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dayliv.dayliv.model.Product;
import com.ibm.icu.math.BigDecimal;

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

	public Map<String, Object> findByMaxAndMinPrice(Float maxPrice, Float minPrice, String storeCode,
			int page, int size);
}

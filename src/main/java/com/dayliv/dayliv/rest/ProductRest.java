package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@DeleteMapping("/{id}")
	public int deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}
	@GetMapping("/store/{storeCode}")
	public List<Product> getProductsByStore(@PathVariable String storeCode){
		return productService.getProductsByStore(storeCode);
	}

	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@PostMapping("/")
	public Product createProduct(@RequestBody Product product) {
		System.out.println(product.getCategoryProduct().getCategory_name());
		return productService.createProduct(product);
	}

	@GetMapping("/")
	public List<Product> findAll() {
		return productService.findAll();
	}
	

}

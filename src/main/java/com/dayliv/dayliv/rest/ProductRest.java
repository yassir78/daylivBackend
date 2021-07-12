package com.dayliv.dayliv.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.service.ProductService;
import com.ibm.icu.math.BigDecimal;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/product")
public class ProductRest {
	@Autowired
	private ProductService productService;

	@GetMapping("/random")
	public List<Product> getProductsRandomly() {
		return productService.getProductsRandomly();
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	@DeleteMapping("/{id}")
	public int deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}

	@GetMapping("/store/{storeCode}")
	public List<Product> getProductsByStore(@PathVariable String storeCode) {
		return productService.getProductsByStore(storeCode);
	}

	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@PostMapping("/")
	public Product createProduct(@RequestBody Product product, @RequestHeader("idUser") String idUser) {
		System.out.println(product.toString());
		return productService.createProduct(product, idUser);
	}

	@GetMapping("/")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/products")
	public ResponseEntity<Map<String, Object>> getAllProducts(@RequestParam(required = false) String name,
			@RequestParam(required = true) String storeCode, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "9") int size) {
		try {
			return new ResponseEntity<>(productService.getAllProducts(name, storeCode, page, size), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/productsByMinAndMaxPrice")
	public Map<String, Object> findByMaxAndMinPrice(@RequestParam String minPrice,
			@RequestParam String maxPrice, @RequestParam String storeCode,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size) {
		System.out.println("*************************");
		System.out.println(minPrice);

		return productService.findByMaxAndMinPrice(Float.valueOf(minPrice), Float.valueOf(maxPrice), storeCode, page, size);
	}

	@GetMapping("/productsBySubCategory")
	public Map<String, Object> findProductsBySubCategoryLink(@RequestParam String link, @RequestParam String storeCode,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size) {
		return productService.findProductsBySubCategoryLink(link, storeCode, page, size);
	}

}

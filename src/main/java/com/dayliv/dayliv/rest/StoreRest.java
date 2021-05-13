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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.service.StoreService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/store")
public class StoreRest {
	@Autowired
	private StoreService storeService;

	@GetMapping("/{id}")
	public Store findById(@PathVariable Long id) {
		return storeService.findById(id);
	}                

	@DeleteMapping("/{id}")
	public void deleteStore(@PathVariable Long id) {
		storeService.deleteStore(id);
	}

	@PutMapping("/update")
	public Store updateStore(@RequestBody Store store) {
		return storeService.updateStore(store);
	}

	@PostMapping("/add")
	public Store createProduct(@RequestBody Store store) {
		return storeService.createStore(store);
	}

	@GetMapping("/all")
	public List<Store> findAll() {
		return storeService.findAll();
	}

	@GetMapping("/code/{code}")
	public Store findByCode(@PathVariable String code) {
		return storeService.findByCode(code);
	}
	

	@GetMapping("/stores")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(storeService.getAllStores(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}

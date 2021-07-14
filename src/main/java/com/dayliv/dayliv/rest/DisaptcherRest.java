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

import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.service.DispatcherService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/dispatcher")
public class DisaptcherRest {
	@Autowired
	private DispatcherService dispatcherService;
	// @Autowired
	// private JwtTokenProvider tokenProvider;


	@GetMapping("/all")
	public List<Dispatcher> findAll() {
		return dispatcherService.findAll();
	}

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable Long id) {
		dispatcherService.delete(id);
	}

	@PutMapping("/")
	public Dispatcher update(@RequestBody Dispatcher dispatcher) {
		return dispatcherService.update(dispatcher.getId(), dispatcher);
	}

	@DeleteMapping("/{id}")
	public int deletePartenaire(@PathVariable Long id) {
		return dispatcherService.delete(id);
	}

	@PostMapping("/save")
	public Dispatcher save(@RequestBody Dispatcher dispatcher) {
		
		return dispatcherService.save(dispatcher);
	}

	@GetMapping("/nom/{nom}")
	public Dispatcher findByNom(@PathVariable String nom) {
		return dispatcherService.findByNom(nom);
	}

	@GetMapping("/id/{id}")
	public Dispatcher findById(@PathVariable Long id) {
		return dispatcherService.findById(id);
	}
	
	

	@GetMapping("/dispatchers")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(dispatcherService.getAllDispatchers(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}

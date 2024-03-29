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

import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.service.ConsumerService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/consumer")   
public class ConsumerRest {
	@Autowired
	private ConsumerService consumerService;
	//@Autowired
	//private JwtTokenProvider tokenProvider;

	@GetMapping("/all")
	public List<Consumer> findAll() {
		return consumerService.findAll();
	}

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable Long id) {
		consumerService.delete(id);
	}

	@PutMapping("/num/{id}")
	public Consumer update(@PathVariable Long id, @RequestBody Consumer consumer) {
		return consumerService.update(id, consumer);
	}

	@PostMapping("/save")
	public Consumer save(@RequestBody Consumer consumer) {
		return consumerService.save(consumer);
	}

	@GetMapping("/nom/{nom}")
	public Consumer findByNom(@PathVariable String nom) {
		return consumerService.findByNom(nom);
	}

	@GetMapping("/id/{id}")
	public Consumer findById(@PathVariable Long id) {
		return consumerService.findById(id);
	}
	
	
	

	@GetMapping("/categories")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(consumerService.getAllConsumers(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	/*

	@GetMapping("/login")
	public ResponseEntity<?> consumerLogin(Principal principal){
        System.out.println("Login debug........." );
	     if(principal == null){
	        return ResponseEntity.ok(principal);
	    }
	    UsernamePasswordAuthenticationToken authenticationToken =
	            (UsernamePasswordAuthenticationToken) principal;
	    Consumer consumer = consumerService.findByLogin(authenticationToken.getName());
	    consumer.setToken(tokenProvider.generateToken(authenticationToken));    
        System.out.println("Login debug........." );
        System.out.println(consumer );
	    return new ResponseEntity<>(consumer, HttpStatus.OK);
	}
	

	@PostMapping("/register")
	public ResponseEntity<?> consumerRegister(@RequestBody Consumer consumer) {
         System.out.println("hello world");
		if (consumerService.findByLogin(consumer.getLogin()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		//consumer.setRole(ERole.CONSUMER);
		return new ResponseEntity<>(consumerService.save(consumer), HttpStatus.CREATED);
	}*/

}

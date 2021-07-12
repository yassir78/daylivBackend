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

import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.LivreurService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/livreur")
public class LivreurRest {
	@Autowired
	private LivreurService livreurService;
	//@Autowired

	@GetMapping("/all")
	public List<Livreur> findAll() {
		return livreurService.findAll();
	}
	
	
	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable Long id) {
		livreurService.delete(id);
	}
	@PutMapping("/num/{id}")
	public Livreur update(@PathVariable Long id,@RequestBody Livreur livreur) {
		return livreurService.update(id, livreur);
	}
	
	@PutMapping("/{id}")
	public Livreur updateLocation(@PathVariable Long id,@RequestBody Livreur livreur) {
		System.out.println("GGGGGGGGGGGGGGGGGGGIGGGGGGGGGGG..*******");
		System.out.println(livreur);
		return livreurService.updateLocation(id, livreur);
	}
	
	
	@PostMapping("/save")
	public Livreur save(@RequestBody Livreur livreur) {
		return livreurService.save(livreur);
	}
	@GetMapping("/nom/{nom}")
	public Livreur findByNom(@PathVariable String nom) {
		return livreurService.findByNom(nom);
	}

	@GetMapping("/id/{id}")
	public Livreur findById(@PathVariable Long id) {
	    return livreurService.findById(id);
	}
	

	@GetMapping("/livreurs")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(livreurService.getAllLivreurs(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

/*
	@PostMapping("/dayliv-api/livreur/register")
	public ResponseEntity<?> livreurRegister(@RequestBody Livreur livreur){
	    if(livreurService.findByLogin(livreur.getLogin())!=null){
	        return new ResponseEntity<>(HttpStatus.CONFLICT);
	    }
	    livreur.setRole(ERole.LIVREUR);
	    return new ResponseEntity<>(livreurService.save(livreur), HttpStatus.CREATED);
	}

	@GetMapping("/dayliv-api/livreur/login")
	public ResponseEntity<?> livreurLogin(Principal principal){
	     if(principal == null){
	        return ResponseEntity.ok(principal);
	    }
	    UsernamePasswordAuthenticationToken authenticationToken =
	            (UsernamePasswordAuthenticationToken) principal;
	    Livreur livreur = livreurService.findByLogin(authenticationToken.getName());
	    livreur.setToken(tokenProvider.generateToken(authenticationToken));

	    return new ResponseEntity<>(livreur, HttpStatus.OK);
	}
*/

}

package com.dayliv.dayliv.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.jwt.JwtTokenProvider;
import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Role;
import com.dayliv.dayliv.service.ConsumerService;
import com.dayliv.dayliv.service.LivreurService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/livreur")
public class LivreurRest {
	@Autowired
	private LivreurService livreurService;
	@Autowired
	private JwtTokenProvider tokenProvider;

	@GetMapping("/all")
	public List<Livreur> findAll() {
		return livreurService.findAll();
	}
	
	
	@DeleteMapping("/dayliv-api/livreur/id/{id}")
	public void delete(@PathVariable Long id) {
		livreurService.delete(id);
	}
	@PutMapping("/dayliv-api/livreur/num/{id}")
	public Livreur update(@PathVariable Long id,@RequestBody Livreur livreur) {
		return livreurService.update(id, livreur);
	}
	@PostMapping("/dayliv-api/livreur/save")
	public Livreur save(@RequestBody Livreur livreur) {
		return livreurService.save(livreur);
	}
	@GetMapping("/dayliv-api/livreur/nom/{nom}")
	public Livreur findByNom(@PathVariable String nom) {
		return livreurService.findByNom(nom);
	}

	@GetMapping("/dayliv-api/livreur/id/{id}")
	public Livreur findById(@PathVariable Long id) {
	    return livreurService.findById(id);
	}


	@PostMapping("/dayliv-api/livreur/register")
	public ResponseEntity<?> livreurRegister(@RequestBody Livreur livreur){
	    if(livreurService.findByLogin(livreur.getLogin())!=null){
	        return new ResponseEntity<>(HttpStatus.CONFLICT);
	    }
	    livreur.setRole(Role.LIVREUR);
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


}

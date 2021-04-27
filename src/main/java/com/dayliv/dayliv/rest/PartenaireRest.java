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

import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.model.Panier;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.ERole;
import com.dayliv.dayliv.service.ConsumerService;
import com.dayliv.dayliv.service.EmailService;
import com.dayliv.dayliv.service.PanierService;
import com.dayliv.dayliv.service.PartenaireService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/partenaire")
public class PartenaireRest {

	@Autowired
	private PartenaireService partenaireService;
	// @Autowired
	// private JwtTokenProvider tokenProvider;

	@Autowired
    private EmailService emailService; 

	@GetMapping("/all")
	public List<Partenaire> findAll() {
		return partenaireService.findAll();
	}

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable Long id) {
		partenaireService.delete(id);
	}

	@PutMapping("/")
	public Partenaire update(@RequestBody Partenaire partenaire) {
		return partenaireService.update(partenaire.getId(), partenaire);
	}

	@DeleteMapping("/{id}")
	public int deletePartenaire(@PathVariable Long id) {
		return partenaireService.delete(id);
	}

	@PostMapping("/save")
	public Partenaire save(@RequestBody Partenaire partenaire) {
		emailService.sendMail(partenaire.getEmail(), "Dayliv Marketplace", "Bonjour nous avons crée un compte pour vous !");
		//emailService.sendMailWithInlineResources(partenaire.getEmail(), "Dayliv Marketplace", "https://cdn.shopify.com/s/files/1/0511/3901/8925/files/Copia_de_Copia_de_REN_1_410x.png");
		return partenaireService.save(partenaire);
	}

	@GetMapping("/nom/{nom}")
	public Partenaire findByNom(@PathVariable String nom) {
		return partenaireService.findByNom(nom);
	}

	@GetMapping("/id/{id}")
	public Partenaire findById(@PathVariable Long id) {
		return partenaireService.findById(id);
	}

	/*
	 * @PostMapping("/register") public ResponseEntity<?>
	 * partenaireRegister(@RequestBody Partenaire partenaire){
	 * if(partenaireService.findByLogin(partenaire.getLogin())!=null){ return new
	 * ResponseEntity<>(HttpStatus.CONFLICT); }
	 * partenaire.setRole(ERole.PARTENAIRE); return new
	 * ResponseEntity<>(partenaireService.save(partenaire), HttpStatus.CREATED); }
	 * 
	 * @GetMapping("/login") public ResponseEntity<?> partenaireLogin(Principal
	 * principal){ if(principal == null){ return ResponseEntity.ok(principal); }
	 * UsernamePasswordAuthenticationToken authenticationToken =
	 * (UsernamePasswordAuthenticationToken) principal; Partenaire partenaire =
	 * partenaireService.findByLogin(authenticationToken.getName());
	 * partenaire.setToken(tokenProvider.generateToken(authenticationToken));
	 * 
	 * return new ResponseEntity<>(partenaire, HttpStatus.OK); }
	 */

}
